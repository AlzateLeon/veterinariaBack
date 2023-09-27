package com.itq.proyecto.repositorio;

import com.itq.proyecto.entidades.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioVacuna extends JpaRepository<Vacuna, Long> {

}
