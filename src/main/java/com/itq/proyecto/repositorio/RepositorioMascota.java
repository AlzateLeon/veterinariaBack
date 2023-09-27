package com.itq.proyecto.repositorio;

import com.itq.proyecto.entidades.Mascota;
import com.itq.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioMascota  extends JpaRepository<Mascota, Long> {

    Optional<List<Mascota>> findByDueno(Usuario user);
}