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
@Table(name = "Mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_MASCOTA")
    private Long idMascota;

    @Column(nullable = false, name = "NOMBRE")
    private String nombre;

    @ManyToOne
    @JoinColumn(nullable = false, name = "DUENO_ID")
    private Usuario dueno;

    @Column(nullable = false, name = "EDAD")
    private int edad;

    @Column(nullable = false, name = "RAZA")
    private String raza;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "TIPO_MASCOTA")
    private TipoMascota tipoMascota;

}
