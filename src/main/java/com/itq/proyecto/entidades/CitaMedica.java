package com.itq.proyecto.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String hora;

    @OneToOne
    @JoinColumn(nullable = false)
    private Mascota mascota;

    @OneToOne
    @JoinColumn(nullable = false)
    private Usuario veterinario;

    @OneToOne
    @JoinColumn(nullable = false)
    private Vacuna vacuna;

}
