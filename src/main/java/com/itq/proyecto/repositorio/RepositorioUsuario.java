package com.itq.proyecto.repositorio;

import com.itq.proyecto.domain.enums.TipoUsuarioEnum;
import com.itq.proyecto.repositorio.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  RepositorioUsuario extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(String correo);

    Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena);

    Optional<Usuario> findByIdUser(Long idUser);

    Optional<Usuario> findByCedula(String cedula);

    @Query("SELECT u FROM Usuario u " +
            " WHERE (:param1 IS NULL OR u.cedula = :param1) " +
            " AND (:param2 IS NULL OR LOWER(u.nombre) like LOWER(CONCAT('%', :param2, '%')))  " +
            " AND (u.tipoUsuarioEnum = :param3)" )
    List<Usuario> consultarUsuariosPorCedulaONombre(@Param("param1") String cedula,
                                               @Param("param2") String nombre,
                                                @Param("param3")TipoUsuarioEnum tipoUsuario);

}
