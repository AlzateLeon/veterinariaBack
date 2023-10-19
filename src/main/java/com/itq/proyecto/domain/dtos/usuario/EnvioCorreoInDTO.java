package com.itq.proyecto.domain.dtos.usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnvioCorreoInDTO {

    private String correo;
    private Long idUser;
}
