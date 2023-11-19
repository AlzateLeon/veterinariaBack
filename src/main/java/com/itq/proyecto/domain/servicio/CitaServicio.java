package com.itq.proyecto.domain.servicio;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.citamedica.ConsultaCitaFiltrosInDTO;
import com.itq.proyecto.domain.dtos.citamedica.ConsultasCitasUserOutDTO;
import com.itq.proyecto.domain.dtos.citamedica.CreacionCitaInDTO;

public interface CitaServicio {
    ResultadoDTO crearCita(CreacionCitaInDTO creacionCitaInDTO);

    ConsultasCitasUserOutDTO consultarCitasUsuario(Long idUser);

    ResultadoDTO cancelarCita(Long idCita);

    ConsultasCitasUserOutDTO consultarCitasFiltros(ConsultaCitaFiltrosInDTO inDTO);
}
