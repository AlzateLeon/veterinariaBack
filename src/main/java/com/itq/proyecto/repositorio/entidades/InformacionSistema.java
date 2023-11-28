package com.itq.proyecto.repositorio.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "INFORMACION_SISTEMA")
public class InformacionSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(nullable = false, name = "ACTUAL")
    private boolean actual;

    @Column(nullable = false, name = "HORARIOS")
    private String horariosAtencion;

    @Column(nullable = false, name = "CORREO")
    private String correo;

    @Column(nullable = false, name = "TELEFONO")
    private String telefono;

    @Column(nullable = false, name = "UBICACION")
    private String ubicacion;
}
