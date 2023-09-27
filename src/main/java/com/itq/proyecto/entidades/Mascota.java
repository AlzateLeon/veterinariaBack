package com.itq.proyecto.entidades;

import com.itq.proyecto.enums.TipoMascota;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @OneToOne
    @JoinColumn(nullable = false)
    private Usuario dueno;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private String raza;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMascota tipoMascota;


}
