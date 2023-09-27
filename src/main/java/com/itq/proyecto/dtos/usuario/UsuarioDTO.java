package com.itq.proyecto.dtos.usuario;

import com.itq.proyecto.dtos.ResultadoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO extends ResultadoDTO {

    private String user;
    private String password;
    private Long id;

}
