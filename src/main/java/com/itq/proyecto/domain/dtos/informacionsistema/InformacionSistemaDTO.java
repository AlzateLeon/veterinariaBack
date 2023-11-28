package com.itq.proyecto.domain.dtos.informacionsistema;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InformacionSistemaDTO extends ResultadoDTO {

    private Long id;
    private boolean actual;
    private String horariosAtencion;
    private String correo;
    private String telefono;
    private String ubicacion;
}
