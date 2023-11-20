package com.itq.proyecto.repositorio;

import com.itq.proyecto.repositorio.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  RepositorioUsuario extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(String correo);

    Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena);

    Optional<Usuario> findByIdUser(Long idUser);

    Optional<Usuario> findByCedula(String cedula);

}
