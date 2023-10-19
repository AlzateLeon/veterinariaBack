package com.itq.proyecto.repositorio.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VacunaAplicada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private Mascota mascota;

    @OneToOne
    @JoinColumn(nullable = false)
    private Vacuna vacuna;

    @Column(nullable = false)
    private LocalDate fechaAplicacion;
}
