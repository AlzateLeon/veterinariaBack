package com.itq.proyecto.repositorio;

import com.itq.proyecto.domain.enums.EstadoCitaMedicaEnum;
import com.itq.proyecto.repositorio.entidades.CitaMedica;
import com.itq.proyecto.repositorio.entidades.Mascota;
import org.kolobok.annotation.FindWithOptionalParams;
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

    @Query("SELECT c FROM CitaMedica c " +
            " WHERE (:param1 IS NULL OR c.fecha = :param1) " +
            " AND (:param2 IS NULL OR c.idUser = :param2)  " +
            " AND (:param3 IS NULL OR c.estadoCitaMedicaEnum = :param3) ")
    List<CitaMedica> buscarPorParametros(@Param("param1") LocalDate fecha,
                                         @Param("param2") Long idUser,
                                         @Param("param3") EstadoCitaMedicaEnum estado);
}
