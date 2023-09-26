package com.itq.proyecto.servicio.impl;

import com.itq.proyecto.dtos.CreacionUsuarioIn;
import com.itq.proyecto.dtos.CreacionUsuarioOut;
import com.itq.proyecto.dtos.UsuarioDTO;
import com.itq.proyecto.entidades.Usuario;
import com.itq.proyecto.repositorio.RepositorioUsuario;
import com.itq.proyecto.servicio.CreacionUsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
            user.setNombre(creacionIn.getNombre());
            user.setContrasena(creacionIn.getPassword());

            repositorioUsuario.save(user);

        } catch (Exception e) {
            creacionOut.setExitoso(false);
            creacionOut.setHttpStatus(HttpStatus.BAD_REQUEST);
        }

        return creacionOut;
    }

    public boolean validarUsuarioExistente(String nombre, String contrasena) {
        Optional<Usuario> usuario = repositorioUsuario.findByNombreAndContrasena(nombre, contrasena);
        return usuario.isPresent();
    }

    @Override
    public UsuarioDTO consutarUsuarioExistente(String user, String contrasena){

        UsuarioDTO userDTO = new UsuarioDTO();
        userDTO.setExitoso(true);
        Optional<Usuario> usuario = repositorioUsuario.findByNombreAndContrasena(user, contrasena);

        if (!usuario.isPresent()){
            userDTO.setExitoso(false);
            userDTO.setMensaje("Usuario no existe");
            return userDTO;
        }

        Usuario userEntity = usuario.get();
        userDTO.setUser(userEntity.getNombre());
        userDTO.setId(userEntity.getId());

        return userDTO;
    }
}
