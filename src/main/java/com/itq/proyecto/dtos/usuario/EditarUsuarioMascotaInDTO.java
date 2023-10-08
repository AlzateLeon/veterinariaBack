package com.itq.proyecto.dtos.usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EditarUsuarioMascotaInDTO {

    private Long idUsuario;
    private String correo;
    private String nombre;
}
