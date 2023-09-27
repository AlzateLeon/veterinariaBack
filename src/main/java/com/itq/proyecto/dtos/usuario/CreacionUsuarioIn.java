package com.itq.proyecto.dtos.usuario;

import com.itq.proyecto.enums.TipoUsuarioEnum;
import jakarta.persistence.Column;
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
