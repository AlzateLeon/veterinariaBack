package com.itq.proyecto.domain.dtos.vacuna;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AplicacionVacunaInDTO {

    private Long idVacuna;
    private Long idMascota;
    private Long idCita;

}
