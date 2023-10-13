package com.itq.proyecto.domain.servicio.impl;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.usuario.CreacionUsuarioIn;
import com.itq.proyecto.domain.dtos.usuario.CreacionUsuarioOut;
import com.itq.proyecto.domain.dtos.usuario.EditarUsuarioMascotaInDTO;
import com.itq.proyecto.domain.dtos.usuario.UsuarioDTO;
import com.itq.proyecto.domain.entidades.Usuario;
import com.itq.proyecto.domain.servicio.CreacionUsuarioServicio;
import com.itq.proyecto.repositorio.RepositorioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CreacionUsuarioServicioImpl implements CreacionUsuarioServicio {

    private RepositorioUsuario repositorioUsuario;


    @Override
    public CreacionUsuarioOut crearUsuario(CreacionUsuarioIn creacionIn) {

        CreacionUsuarioOut creacionOut = new CreacionUsuarioOut();
        creacionOut.setExitoso(true);
        creacionOut.setHttpStatus(HttpStatus.OK);

        try {
            if (validarUsuarioExistente(creacionIn.getCorreo())){

                creacionOut.setExitoso(false);
                creacionOut.setHttpStatus(HttpStatus.OK);
                creacionOut.setMensaje("Usuario con el correo ingresado ya existe");
                return creacionOut;
            }

            Usuario user  = new Usuario();
            user.setContrasena(creacionIn.getPassword());
            user.setNombre(creacionIn.getNombre());
            user.setCorreo(creacionIn.getCorreo());
            user.setCedula(creacionIn.getCedula());
            user.setTipoUsuarioEnum(creacionIn.getTipoUsuarioEnum());

            repositorioUsuario.save(user);

        } catch (Exception e) {
            creacionOut.setExitoso(false);
            creacionOut.setHttpStatus(HttpStatus.BAD_REQUEST);
            creacionOut.setMensaje(e.getMessage());
        }

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
        userDTO.setNombre(userEntity.getNombre());
        userDTO.setIdUser(userEntity.getIdUser());
        userDTO.setCorreo(userEntity.getCorreo());
        userDTO.setContrasena(userEntity.getContrasena());
        userDTO.setCedula(userEntity.getCedula());
        userDTO.setTipoUsuarioEnum(userEntity.getTipoUsuarioEnum());

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

            repositorioUsuario.save(userEntity);

        } catch (Exception e) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al editar el Usuario, causa: " + e.getMessage());
        }

        return resultadoDTO;
    }
}
