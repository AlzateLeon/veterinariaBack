package com.itq.proyecto.dtos.usuario;

import com.itq.proyecto.dtos.ResultadoDTO;
import com.itq.proyecto.enums.TipoUsuarioEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO extends ResultadoDTO {

    private Long idUser;
    private String nombre;
    private String contrasena;
    private TipoUsuarioEnum tipoUsuarioEnum;
    private String correo;
    private String cedula;

}
