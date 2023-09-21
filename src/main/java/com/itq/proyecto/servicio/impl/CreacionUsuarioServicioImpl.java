package com.itq.proyecto.servicio.impl;

import com.itq.proyecto.dtos.CreacionUsuarioIn;
import com.itq.proyecto.dtos.CreacionUsuarioOut;
import com.itq.proyecto.entidades.Usuario;
import com.itq.proyecto.repositorio.RepositorioUsuario;
import com.itq.proyecto.servicio.CreacionUsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

            Usuario user  = new Usuario();
            user.setNombre(creacionIn.getNombre());
            repositorioUsuario.save(user);

        } catch (Exception e) {
            creacionOut.setExitoso(false);
            creacionOut.setHttpStatus(HttpStatus.BAD_REQUEST);
        }

        return creacionOut;
    }
}
