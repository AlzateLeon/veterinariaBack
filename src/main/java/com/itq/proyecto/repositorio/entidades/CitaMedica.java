package com.itq.proyecto.repositorio.entidades;

import com.itq.proyecto.domain.enums.EstadoCitaMedicaEnum;
import com.itq.proyecto.domain.enums.TipoCitaMascotaEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CITA_MEDICA")
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @Column(name = "FECHA_ACTUALIZACION", nullable = true)
    private LocalDate fechaActualizacion;

    @Column(name = "HORA", nullable = false)
    private String hora;

    @ManyToOne
    @JoinColumn(name = "MASCOTA", nullable = false)
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "VETERINARIO", nullable = true)
    private Usuario veterinario;

    @ManyToOne
    @JoinColumn(name = "VACUNA", nullable = true)
    private Vacuna vacuna;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_PROCESO", nullable = false)
    private TipoCitaMascotaEnum tipoCitaMascotaEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO_CITA", nullable = false)
    private EstadoCitaMedicaEnum estadoCitaMedicaEnum;

    @Column(name = "ID_USER", nullable = true)
    private Long idUser;

    @Column(name = "OBSERVACION", nullable = true)
    private String observaciones;

}
