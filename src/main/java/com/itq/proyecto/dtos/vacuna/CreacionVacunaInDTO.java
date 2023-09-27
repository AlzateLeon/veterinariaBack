package com.itq.proyecto.dtos.vacuna;

import com.itq.proyecto.enums.TipoMascota;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreacionVacunaInDTO {

    private String nombre;
    private TipoMascota tipoMascota;
}
