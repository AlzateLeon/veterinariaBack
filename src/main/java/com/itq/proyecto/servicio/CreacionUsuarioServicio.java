package com.itq.proyecto.servicio;

import com.itq.proyecto.dtos.CreacionUsuarioIn;
import com.itq.proyecto.dtos.CreacionUsuarioOut;
import com.itq.proyecto.dtos.UsuarioDTO;

public interface CreacionUsuarioServicio {

    CreacionUsuarioOut crearUsuario(CreacionUsuarioIn creacionIn);

    UsuarioDTO consutarUsuarioExistente(String user, String contrasena);
}

