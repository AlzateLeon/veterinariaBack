package com.itq.proyecto.servicio.impl;

import com.itq.proyecto.dtos.ResultadoDTO;
import com.itq.proyecto.dtos.usuario.CreacionUsuarioIn;
import com.itq.proyecto.dtos.usuario.CreacionUsuarioOut;
import com.itq.proyecto.dtos.usuario.UsuarioDTO;
import com.itq.proyecto.entidades.Usuario;
import com.itq.proyecto.repositorio.RepositorioUsuario;
import com.itq.proyecto.servicio.CreacionUsuarioServicio;
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
            if (validarUsuarioExistente(creacionIn.getNombre(), creacionIn.getPassword())){

                creacionOut.setExitoso(false);
                creacionOut.setHttpStatus(HttpStatus.OK);
                creacionOut.setMensaje("Usuario ya existe");
                return creacionOut;
            }

            Usuario user  = new Usuario();
            user.setContrasena(creacionIn.getPassword());
            user.setNombre(creacionIn.getNombre());
            user.setUserName(creacionIn.getUserName());
            user.setCorreo(creacionIn.getCorreo());
            user.setCedula(creacionIn.getCedula());
            user.setTipoUsuarioEnum(creacionIn.getTipoUsuarioEnum());

            repositorioUsuario.save(user);

        } catch (Exception e) {
            creacionOut.setExitoso(false);
            creacionOut.setHttpStatus(HttpStatus.BAD_REQUEST);
        }

        return creacionOut;
    }

    public boolean validarUsuarioExistente(String user, String contrasena) {
        Optional<Usuario> usuario = repositorioUsuario.findByUserNameAndContrasena(user, contrasena);
        return usuario.isPresent();
    }

    @Override
    public UsuarioDTO consutarUsuarioExistente(String user, String contrasena){

        UsuarioDTO userDTO = new UsuarioDTO();
        userDTO.setExitoso(true);
        Optional<Usuario> usuario = repositorioUsuario.findByUserNameAndContrasena(user, contrasena);

        if (!usuario.isPresent()){
            userDTO.setExitoso(false);
            userDTO.setMensaje("Usuario no existe");
            return userDTO;
        }

        Usuario userEntity = usuario.get();
        userDTO.setUser(userEntity.getNombre());
        userDTO.setId(userEntity.getIdUser());

        return userDTO;
    }

    @Override
    public ResultadoDTO crearVeterinario(CreacionUsuarioIn creacionUsuarioIn) {

        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try{
            resultadoDTO = crearUsuario(creacionUsuarioIn);

        } catch (Exception e) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al crear la mascota, causa: " + e.getMessage());
        }

        return resultadoDTO;
    }
}
