package io.reflectoring.sparky.usuario.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.reflectoring.sparky.usuario.domain.Usuario;

@Repository
public interface UsuarioRepository<T extends Usuario> extends JpaRepository<T, Long> {
    T findByEmail(String email);
}
