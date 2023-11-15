package com.itq.proyecto.domain.dtos.citamedica;

import com.itq.proyecto.domain.dtos.mascota.MascotaDTO;
import com.itq.proyecto.domain.dtos.usuario.UsuarioDTO;
import com.itq.proyecto.domain.enums.EstadoCitaMedicaEnum;
import com.itq.proyecto.domain.enums.TipoCitaMascotaEnum;
import com.itq.proyecto.repositorio.entidades.Usuario;
import com.itq.proyecto.repositorio.entidades.Mascota;
import com.itq.proyecto.repositorio.entidades.Vacuna;
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
    private String nombreMascota;
    private String nombreVeterinario;
    private EstadoCitaMedicaEnum estadoCitaMedicaEnum;
    private TipoCitaMascotaEnum tipoCitaMascotaEnum;
    private String nombreVacuna;
    private String observaciones;
}
