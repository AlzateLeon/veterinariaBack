package com.itq.proyecto.domain.dtos.citamedica;

import com.itq.proyecto.domain.enums.TipoCitaMascotaEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreacionCitaInDTO {

    private Long idMascota;
    private Long idUser;
    private Long idVacuna;
    private Long idVeterinario;
    private LocalDate fecha;
    private String hora;
    private TipoCitaMascotaEnum tipoCitaMascotaEnum;
}
