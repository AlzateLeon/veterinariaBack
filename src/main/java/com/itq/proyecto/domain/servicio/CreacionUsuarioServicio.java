package com.itq.proyecto.domain.servicio;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.usuario.*;
import org.springframework.web.bind.annotation.PathVariable;

public interface CreacionUsuarioServicio {

    CreacionUsuarioOutDTO crearUsuario(CreacionUsuarioIn creacionIn);

    UsuarioDTO consutarUsuarioExistenteCorreoContraena(String correo, String password);

    ResultadoDTO crearVeterinario(CreacionUsuarioIn creacionUsuarioIn);

    ResultadoDTO editarUsuarioMascota(EditarUsuarioMascotaInDTO editarusuarioMascotaIn);

    ResultadoDTO mandarCorreoValidacion(EnvioCorreoInDTO envioCorreoInDTO);

    public ResultadoDTO activarCuenta(ActivarCuentaDTO activarCuentaDTO);

}

