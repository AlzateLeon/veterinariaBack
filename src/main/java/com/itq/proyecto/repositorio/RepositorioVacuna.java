package com.itq.proyecto.repositorio;

import com.itq.proyecto.domain.enums.TipoMascota;
import com.itq.proyecto.repositorio.entidades.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioVacuna extends JpaRepository<Vacuna, Long> {

    @Query("SELECT v FROM Vacuna v " +
            " WHERE (:param1 IS NULL OR v.tipoMascota = :param1) ")
    List<Vacuna> consultarVacunasTipoMascota(@Param("param1")TipoMascota tipo) ;
}
