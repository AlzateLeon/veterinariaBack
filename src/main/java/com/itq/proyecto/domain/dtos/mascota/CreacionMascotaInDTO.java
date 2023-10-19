package com.itq.proyecto.domain.dtos.mascota;

import com.itq.proyecto.domain.enums.TipoMascota;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreacionMascotaInDTO {

    private String nombre;
    private Long idDueno;
    private int edad;
    private String tipoMascota;
    private String raza;

    @Override
    public String toString() {
        return "CreacionMascotaInDTO{" +
                "nombre='" + nombre + '\'' +
                ", idDueno=" + idDueno +
                ", edad=" + edad +
                ", tipoMascota='" + tipoMascota + '\'' +
                ", raza='" + raza + '\'' +
                '}';
    }
}
