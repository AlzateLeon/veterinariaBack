package com.itq.proyecto.domain.dtos.usuario;

import com.itq.proyecto.domain.enums.TipoUsuarioEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreacionUsuarioIn {

    private String nombre;
    private String password;
    private TipoUsuarioEnum tipoUsuarioEnum;
    private String userName;
    private String correo;
    private String cedula;

}
