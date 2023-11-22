package com.itq.proyecto.domain.dtos.usuario;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ConsultaUsuariosFiltrosOutDTO extends ResultadoDTO {

    List<UsuarioDTO> usuarios;
}
