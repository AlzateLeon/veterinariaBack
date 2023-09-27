package com.itq.proyecto.servicio;

import com.itq.proyecto.dtos.ResultadoDTO;
import com.itq.proyecto.dtos.usuario.CreacionUsuarioIn;
import com.itq.proyecto.dtos.usuario.CreacionUsuarioOut;
import com.itq.proyecto.dtos.usuario.UsuarioDTO;

public interface CreacionUsuarioServicio {

    CreacionUsuarioOut crearUsuario(CreacionUsuarioIn creacionIn);

    UsuarioDTO consutarUsuarioExistente(String user, String contrasena);

    ResultadoDTO crearVeterinario(CreacionUsuarioIn creacionUsuarioIn);
}

