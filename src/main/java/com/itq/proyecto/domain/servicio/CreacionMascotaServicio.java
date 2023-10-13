package com.itq.proyecto.domain.servicio;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.mascota.ConsultaMascotasUsuarioOutDTO;
import com.itq.proyecto.domain.dtos.mascota.CreacionMascotaInDTO;

public interface CreacionMascotaServicio {

    ResultadoDTO crearMascota(CreacionMascotaInDTO creacionIn);

    ConsultaMascotasUsuarioOutDTO consutarMascotasPorUsuario(Long idUser);
}
