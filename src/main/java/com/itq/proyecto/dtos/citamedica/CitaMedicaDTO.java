package com.itq.proyecto.dtos.citamedica;

import com.itq.proyecto.entidades.Mascota;
import com.itq.proyecto.entidades.Usuario;
import com.itq.proyecto.entidades.Vacuna;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CitaMedicaDTO {

    private Long id;
    private LocalDate fecha;
    private String hora;
    private Mascota mascota;
    private Usuario veterinario;
    private Vacuna vacuna;
}
