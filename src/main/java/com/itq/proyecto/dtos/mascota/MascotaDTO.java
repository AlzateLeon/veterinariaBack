package com.itq.proyecto.dtos.mascota;

import com.itq.proyecto.entidades.Usuario;
import com.itq.proyecto.enums.TipoMascota;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MascotaDTO {

    private Long id;
    private String nombre;
    private Usuario dueno;
    private int edad;
    private String raza;
    private TipoMascota tipoMascota;
    private boolean clicked ;
}
