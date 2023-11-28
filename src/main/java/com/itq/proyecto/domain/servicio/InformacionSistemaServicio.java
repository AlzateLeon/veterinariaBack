package com.itq.proyecto.domain.servicio;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.informacionsistema.InformacionSistemaDTO;

public interface InformacionSistemaServicio {
    InformacionSistemaDTO consutarInformacionSistemaActual();

    ResultadoDTO editarInformacionActual(InformacionSistemaDTO info);
}
