package com.itq.proyecto.domain.servicio;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.vacuna.AplicacionVacunaInDTO;
import com.itq.proyecto.domain.dtos.vacuna.CreacionVacunaInDTO;

public interface VacunaServicio {

    ResultadoDTO crearVacuna(CreacionVacunaInDTO creacionIn);

    ResultadoDTO aplicarVacuna(AplicacionVacunaInDTO aplicacionVacunaInDTO);
}
