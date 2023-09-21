package com.itq.proyecto.servicio;

import com.itq.proyecto.dtos.CreacionUsuarioIn;
import com.itq.proyecto.dtos.CreacionUsuarioOut;

public interface CreacionUsuarioServicio {

    CreacionUsuarioOut crearUsuario(CreacionUsuarioIn creacionIn);
}

