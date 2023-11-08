package com.itq.proyecto.repositorio;

import com.itq.proyecto.domain.activationrequest.ActivationRequest;
import com.itq.proyecto.repositorio.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioActivationRequest extends JpaRepository<ActivationRequest, Long> {

    Optional<ActivationRequest>  findByToken(String token);
}
