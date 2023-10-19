package com.itq.proyecto.domain.dtos.usuario;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActivarCuentaDTO {

    private String token;
    private Long idUsuario;
    private String correo;
    private String contrasena;
}
