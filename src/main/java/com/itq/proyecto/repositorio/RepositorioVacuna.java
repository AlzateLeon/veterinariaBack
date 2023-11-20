package com.itq.proyecto.repositorio;

import com.itq.proyecto.domain.enums.TipoMascota;
import com.itq.proyecto.repositorio.entidades.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioVacuna extends JpaRepository<Vacuna, Long> {

    List<Vacuna> findAllByTipoMascota(TipoMascota tipo) ;
}
