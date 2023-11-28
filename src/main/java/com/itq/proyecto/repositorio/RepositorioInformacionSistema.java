package com.itq.proyecto.repositorio;

import com.itq.proyecto.repositorio.entidades.InformacionSistema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioInformacionSistema extends JpaRepository<InformacionSistema, Long> {

    Optional<InformacionSistema> findByActualTrue();
}
