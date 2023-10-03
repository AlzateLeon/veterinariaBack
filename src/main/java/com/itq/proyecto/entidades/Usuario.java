package com.itq.proyecto.entidades;

import com.itq.proyecto.enums.TipoUsuarioEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @Column(nullable = true)
    private String nombre;

    @Column(nullable = false)
    private String contrasena;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuarioEnum tipoUsuarioEnum;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = true)
    private String cedula;

}
