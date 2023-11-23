package com.itq.proyecto.repositorio.entidades;

import com.itq.proyecto.domain.enums.TipoMascota;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "VACUNA")
public class Vacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(nullable = false, name = "NOMBRE")
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "TIPO_MASCOTA")
    private TipoMascota tipoMascota;

    @Column(nullable = true, name = "OBSERVACION")
    private String observaciones;

    @Column(nullable = true, name = "UNIDADES")
    private Integer unidades;

}
