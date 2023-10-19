package com.itq.proyecto.domain.dtos.usuario;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreacionUsuarioOutDTO extends ResultadoDTO {

    private Long idUser;
}
