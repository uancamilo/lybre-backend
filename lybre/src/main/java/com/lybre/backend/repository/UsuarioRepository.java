package com.lybre.backend.repository;

import com.lybre.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar usuario por email
    Optional<Usuario> findByEmail(String email);

    // Buscar usuario por id
    Optional<Usuario> findById(Long id);

    // Buscar usuarios por nombre (puede haber varios con el mismo nombre)
    List<Usuario> findByNombre(String nombre);

    // Buscar usuarios por apellido (puede haber varios con el mismo apellido)
    List<Usuario> findByApellido(String apellido);

    // Buscar usuarios por nombre y apellido
    List<Usuario> findByNombreAndApellido(String nombre, String apellido);
}
