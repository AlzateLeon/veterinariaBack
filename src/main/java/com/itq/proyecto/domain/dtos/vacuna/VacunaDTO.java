package com.itq.proyecto.domain.dtos.vacuna;

import com.itq.proyecto.domain.enums.TipoMascota;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VacunaDTO {

    private Long id;
    private String nombre;
    private String observaciones;
    private TipoMascota tipoMascota;
    private int unidadDisponible;
}
