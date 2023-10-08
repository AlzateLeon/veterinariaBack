package com.itq.proyecto.servicio;

import com.itq.proyecto.dtos.ResultadoDTO;
import com.itq.proyecto.dtos.usuario.CreacionUsuarioIn;
import com.itq.proyecto.dtos.usuario.CreacionUsuarioOut;
import com.itq.proyecto.dtos.usuario.EditarUsuarioMascotaInDTO;
import com.itq.proyecto.dtos.usuario.UsuarioDTO;

public interface CreacionUsuarioServicio {

    CreacionUsuarioOut crearUsuario(CreacionUsuarioIn creacionIn);

    UsuarioDTO consutarUsuarioExistenteCorreoContraena(String correo, String password);

    ResultadoDTO crearVeterinario(CreacionUsuarioIn creacionUsuarioIn);

    ResultadoDTO editarUsuarioMascota(EditarUsuarioMascotaInDTO editarusuarioMascotaIn);
}

