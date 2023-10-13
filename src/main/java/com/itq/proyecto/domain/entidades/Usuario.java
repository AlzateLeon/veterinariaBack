package com.itq.proyecto.domain.entidades;

import com.itq.proyecto.domain.enums.TipoUsuarioEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDUSER")
    private Long idUser;

    @Column(nullable = true, name = "NOMBRE")
    private String nombre;

    @Column(nullable = false, name = "CONTRASENA")
    private String contrasena;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "TIPOUSUARIOENUM")
    private TipoUsuarioEnum tipoUsuarioEnum;

    @Column(nullable = false, name = "CORREO")
    private String correo;

    @Column(nullable = true, name = "CEDULA")
    private String cedula;

    @OneToMany(mappedBy = "dueno", cascade = CascadeType.ALL)
    private List<Mascota> mascotas;

}