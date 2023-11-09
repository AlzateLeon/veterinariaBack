package com.itq.proyecto.repositorio;

import com.itq.proyecto.repositorio.entidades.CitaMedica;
import com.itq.proyecto.repositorio.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioCita extends JpaRepository<CitaMedica, Long> {

    Optional<CitaMedica> findById(Long idCita);

    List<CitaMedica> findAllByIdUser(Long iduser);
}
