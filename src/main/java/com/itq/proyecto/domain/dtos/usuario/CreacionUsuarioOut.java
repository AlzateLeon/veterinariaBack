package com.itq.proyecto.domain.dtos.usuario;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class CreacionUsuarioOut extends ResultadoDTO {

    private HttpStatus httpStatus;

}
