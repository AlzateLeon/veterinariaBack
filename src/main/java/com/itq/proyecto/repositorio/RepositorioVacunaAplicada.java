package com.itq.proyecto.repositorio;

import com.itq.proyecto.entidades.Vacuna;
import com.itq.proyecto.entidades.VacunaAplicada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioVacunaAplicada  extends JpaRepository<VacunaAplicada, Long> {
}
