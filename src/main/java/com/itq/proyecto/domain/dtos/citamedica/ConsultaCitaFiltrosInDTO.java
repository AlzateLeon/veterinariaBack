package com.itq.proyecto.domain.dtos.citamedica;

import com.itq.proyecto.domain.enums.EstadoCitaMedicaEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ConsultaCitaFiltrosInDTO {

    private LocalDate fecha;
    private String cedula;
    private EstadoCitaMedicaEnum estado;

}
