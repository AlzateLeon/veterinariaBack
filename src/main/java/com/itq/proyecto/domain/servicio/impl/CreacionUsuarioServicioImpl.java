package com.itq.proyecto.domain.servicio.impl;

import com.itq.proyecto.domain.activationrequest.ActivationRequest;
import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.usuario.*;
import com.itq.proyecto.domain.enums.EstadoCitaMedicaEnum;
import com.itq.proyecto.domain.enums.TipoUsuarioEnum;
import com.itq.proyecto.repositorio.RepositorioActivationRequest;
import com.itq.proyecto.repositorio.RepositorioCita;
import com.itq.proyecto.repositorio.entidades.Usuario;
import com.itq.proyecto.domain.servicio.CreacionUsuarioServicio;
import com.itq.proyecto.repositorio.RepositorioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CreacionUsuarioServicioImpl implements CreacionUsuarioServicio {

    private RepositorioUsuario repositorioUsuario;

    private JavaMailSender javaMailSender;

    private RepositorioActivationRequest repositorioActivationRequest;

    private RepositorioCita repositorioCita;

    @Override
    public CreacionUsuarioOutDTO crearUsuario(CreacionUsuarioIn creacionIn) {

        CreacionUsuarioOutDTO creacionOut = new CreacionUsuarioOutDTO();
        creacionOut.setExitoso(true);
        Usuario user  = new Usuario();

        try {
            if (validarUsuarioExistente(creacionIn.getCorreo())){

                creacionOut.setExitoso(false);
                creacionOut.setMensaje("Usuario con el correo ingresado ya existe");
                return creacionOut;
            }

            user.setContrasena(creacionIn.getPassword());
            user.setNombre(creacionIn.getNombre());
            user.setCorreo(creacionIn.getCorreo());
            user.setCedula(creacionIn.getCedula());
            user.setTipoUsuarioEnum(creacionIn.getTipoUsuarioEnum());
            user.setCelular(creacionIn.getCelular());
            user.setActivo(false);

            repositorioUsuario.save(user);

        } catch (Exception e) {
            creacionOut.setExitoso(false);
            creacionOut.setMensaje(e.getMessage());
        }

        creacionOut.setIdUser(user.getIdUser());
        return creacionOut;
    }

    @Override
    public UsuarioDTO consutarUsuarioExistenteCorreoContraena(String correo, String password) {
        UsuarioDTO userDTO = new UsuarioDTO();
        userDTO.setExitoso(true);
        Optional<Usuario> usuario = repositorioUsuario.findByCorreoAndContrasena(correo, password);

        if (!usuario.isPresent()){
            userDTO.setExitoso(false);
            userDTO.setMensaje("Usuario no existe");
            return userDTO;
        }

        Usuario userEntity = usuario.get();
        userDTO = crearUsuarioDTO(userEntity);

        return userDTO;
    }

    private UsuarioDTO crearUsuarioDTO(Usuario userEntity) {

        UsuarioDTO userDTO = new UsuarioDTO();
        userDTO.setExitoso(true);
        userDTO.setNombre(userEntity.getNombre());
        userDTO.setIdUser(userEntity.getIdUser());
        userDTO.setCorreo(userEntity.getCorreo());
        userDTO.setContrasena(userEntity.getContrasena());
        userDTO.setCedula(userEntity.getCedula());
        userDTO.setTipoUsuarioEnum(userEntity.getTipoUsuarioEnum());
        userDTO.setActivo(userEntity.isActivo());
        userDTO.setCantidadMascotas(userEntity.getMascotas().size());
        userDTO.setImagenUser(userEntity.getImagen());
        userDTO.setCelular(userEntity.getCelular());
        userDTO.setCitasPendientes(repositorioCita.
                countByEstadoCitaMedicaEnumAndIdUser(EstadoCitaMedicaEnum.PROGRAMADA,
                        userEntity.getIdUser()));
        
        return userDTO;
    }

    public boolean validarUsuarioExistente(String correo) {
        Optional<Usuario> usuario = repositorioUsuario.findByCorreo(correo);
        return usuario.isPresent();
    }


    @Override
    public ResultadoDTO crearVeterinario(CreacionUsuarioIn creacionUsuarioIn) {

        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try{
            resultadoDTO = crearUsuario(creacionUsuarioIn);

        } catch (Exception e) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al crear el veterinario, causa: " + e.getMessage());
        }

        return resultadoDTO;
    }

    @Override
    public ResultadoDTO editarUsuarioMascota(EditarUsuarioMascotaInDTO editarusuarioMascotaIn) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try{
            Optional<Usuario> usuario = repositorioUsuario.findByIdUser(editarusuarioMascotaIn.getIdUsuario());

            if (!usuario.isPresent()){
                resultadoDTO.setExitoso(false);
                resultadoDTO.setMensaje("Usuario no existe");
                return resultadoDTO;
            }

            Usuario userEntity = usuario.get();
            userEntity.setNombre(editarusuarioMascotaIn.getNombre());
            userEntity.setCorreo(editarusuarioMascotaIn.getCorreo());
            userEntity.setCelular(editarusuarioMascotaIn.getCelular());
            userEntity.setImagen(editarusuarioMascotaIn.getImagen());

            repositorioUsuario.save(userEntity);

        } catch (Exception e) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al editar el Usuario, causa: " + e.getMessage());
        }

        return resultadoDTO;
    }

    @Override
    public ResultadoDTO mandarCorreoValidacion(EnvioCorreoInDTO envioCorreoInDTO) {

        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try {

            // Crea una solicitud de activación y la agrega al servicio
            ActivationRequest activationRequest = new ActivationRequest(envioCorreoInDTO.getCorreo());
            repositorioActivationRequest.save(activationRequest);

            // Envia un correo electrónico con el enlace de activación
            String activacionLink = "http://localhost:4200/validar-mail/" +
                    activationRequest.getToken() + "/" + envioCorreoInDTO.getIdUser();
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(envioCorreoInDTO.getCorreo());
            mailMessage.setSubject("Activación de cuenta");
            mailMessage.setText("Por favor, haga clic en el enlace para activar su cuenta: " + activacionLink);
            javaMailSender.send(mailMessage);

        } catch (Exception e){
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje(e.getMessage());
        }

        return resultadoDTO;
    }

    @Override
    public ResultadoDTO activarCuenta(ActivarCuentaDTO activarCuentaDTO) {

        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try{
            Optional<ActivationRequest> activationRequest = repositorioActivationRequest.findByToken(activarCuentaDTO.getToken());

            if (activationRequest.isPresent()) {

                ActivationRequest ar = activationRequest.get();
                boolean vencido = ar.getExpirationDate().before(new Date());
                if (!vencido){
                    Optional<Usuario> usuario = repositorioUsuario.findByIdUser(activarCuentaDTO.getIdUsuario());

                    if(usuario.isPresent()){
                        Usuario user = usuario.get();
                        user.setActivo(true);
                        repositorioUsuario.save(user);
                    }

                }else{
                    resultadoDTO.setExitoso(false);
                    resultadoDTO.setMensaje("El enlace de activación no es válido o ha expirado.");
                }

            }else{
                resultadoDTO.setExitoso(false);
                resultadoDTO.setMensaje("Activation request no existe");
            }

        } catch (Exception e){
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje(e.getMessage());
        }

        return resultadoDTO;

    }

    @Override
    public ConsultaUsuariosFiltrosOutDTO consultarCitasFiltros(ConsultaUsuariosFiltrosInDTO inDTO) {
        ConsultaUsuariosFiltrosOutDTO consultaUsuariosFiltrosOutDTO = new ConsultaUsuariosFiltrosOutDTO();
        consultaUsuariosFiltrosOutDTO.setExitoso(true);

        try{
            List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
            List<Usuario> usuarios =  repositorioUsuario.consultarUsuariosPorCedulaONombre(
                    inDTO.getCedula(), inDTO.getNombre(), TipoUsuarioEnum.DUENO_MASCOTA);
            
            if (!usuarios.isEmpty()){
                for (Usuario user :
                        usuarios) {
                    usuarioDTOS.add(crearUsuarioDTO(user));
                }
            }

            consultaUsuariosFiltrosOutDTO.setUsuarios(usuarioDTOS);
        } catch (Exception e){
            consultaUsuariosFiltrosOutDTO.setExitoso(false);
            consultaUsuariosFiltrosOutDTO.setMensaje(e.getMessage());
        }
        return  consultaUsuariosFiltrosOutDTO;
    }
}
