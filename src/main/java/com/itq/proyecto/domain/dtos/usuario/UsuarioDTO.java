package com.itq.proyecto.domain.dtos.usuario;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.enums.TipoUsuarioEnum;
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
    private boolean activo;
    private int cantidadMascotas;
    private String imagenUser;
    private int citasPendientes;
    private String celular;


}
