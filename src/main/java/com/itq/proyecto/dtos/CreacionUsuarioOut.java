package com.itq.proyecto.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class CreacionUsuarioOut {

    private boolean exitoso;

    private String mensaje;

    private HttpStatus httpStatus;

}
