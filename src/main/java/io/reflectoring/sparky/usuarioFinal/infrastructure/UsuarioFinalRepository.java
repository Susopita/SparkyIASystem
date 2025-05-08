package io.reflectoring.sparky.usuarioFinal.infrastructure;

import org.springframework.stereotype.Repository;

import io.reflectoring.sparky.usuario.infrastructure.UsuarioRepository;
import io.reflectoring.sparky.usuarioFinal.domain.UsuarioFinal;

@Repository
public interface UsuarioFinalRepository extends UsuarioRepository<UsuarioFinal> {
}
