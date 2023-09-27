package com.itq.proyecto.servicio;

import com.itq.proyecto.dtos.ResultadoDTO;
import com.itq.proyecto.dtos.vacuna.CreacionVacunaInDTO;

import java.util.List;

public interface VacunaServicio {

    ResultadoDTO crearVacuna(CreacionVacunaInDTO creacionIn);

    ResultadoDTO aplicarVacuna(Long idvacuna, Long idMascota);
}
