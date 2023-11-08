package com.itq.proyecto.domain.dtos.mascota;

import com.itq.proyecto.domain.enums.TipoMascota;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EditarMascotaInDTO {

    private Long idMascota;
    private String nombre;
    private String raza;
    private TipoMascota tipoMascota;
    private String imagen;
    private int edad;
    private String observacion;

}
