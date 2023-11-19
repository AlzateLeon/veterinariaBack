package com.itq.proyecto.domain.dtos.mascota;

import com.itq.proyecto.domain.dtos.citamedica.CitaMedicaDTO;
import com.itq.proyecto.repositorio.entidades.Usuario;
import com.itq.proyecto.domain.enums.TipoMascota;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private String imagenMascota;
    private String observacion;

    private List<CitaMedicaDTO> listaServicios;

}
