package com.itq.proyecto.servicio;

import com.itq.proyecto.dtos.ResultadoDTO;
import com.itq.proyecto.dtos.mascota.CreacionMascotaInDTO;
import com.itq.proyecto.dtos.mascota.MascotaDTO;

import java.util.List;

public interface CreacionMascotaServicio {

    ResultadoDTO crearMascota(CreacionMascotaInDTO creacionIn);

    List<MascotaDTO> consutarMascotasPorUsuario(Long idUser);
}
