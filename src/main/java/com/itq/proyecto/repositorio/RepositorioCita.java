package com.itq.proyecto.repositorio;

import com.itq.proyecto.domain.enums.EstadoCitaMedicaEnum;
import com.itq.proyecto.repositorio.entidades.CitaMedica;
import com.itq.proyecto.repositorio.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RepositorioCita extends JpaRepository<CitaMedica, Long> {

    Optional<CitaMedica> findById(Long idCita);

    List<CitaMedica> findAllByIdUser(Long iduser);

    int countByEstadoCitaMedicaEnumAndIdUser(EstadoCitaMedicaEnum estado, Long idUser);

    List<CitaMedica> findAllByMascota(Mascota mascota);

    @Query(" SELECT c FROM CitaMedica c join fetch c.usuario u " +
            " WHERE (:fecha IS NULL OR c.fecha = :fecha) " +
            " AND (:cedula IS NULL OR u.cedula = :cedula) ")
    List<CitaMedica> buscarCitasPorParametros(@Param("fecha") LocalDate fecha, String cedula);
}
