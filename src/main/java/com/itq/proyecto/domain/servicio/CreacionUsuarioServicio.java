package com.itq.proyecto.domain.servicio;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.usuario.CreacionUsuarioIn;
import com.itq.proyecto.domain.dtos.usuario.CreacionUsuarioOut;
import com.itq.proyecto.domain.dtos.usuario.EditarUsuarioMascotaInDTO;
import com.itq.proyecto.domain.dtos.usuario.UsuarioDTO;

public interface CreacionUsuarioServicio {

    CreacionUsuarioOut crearUsuario(CreacionUsuarioIn creacionIn);

    UsuarioDTO consutarUsuarioExistenteCorreoContraena(String correo, String password);

    ResultadoDTO crearVeterinario(CreacionUsuarioIn creacionUsuarioIn);

    ResultadoDTO editarUsuarioMascota(EditarUsuarioMascotaInDTO editarusuarioMascotaIn);
}

