package com.itq.proyecto.domain.dtos.vacuna;

import com.itq.proyecto.domain.enums.TipoMascota;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreacionVacunaInDTO {

    private String nombre;
    private TipoMascota tipoMascota;
    private String observaciones;
    private int unidadades;
}
