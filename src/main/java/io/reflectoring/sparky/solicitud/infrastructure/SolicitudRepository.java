package io.reflectoring.sparky.solicitud.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.reflectoring.sparky.solicitud.domain.Solicitud;
import io.reflectoring.sparky.usuario.domain.Usuario;
import java.util.List;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    List<Solicitud> findByUsuario(Usuario usuario);

    // Permite obtener solicitudes por ID de usuario antes de integrar la capa de seguridad
    List<Solicitud> findByUsuarioId(Long usuarioId);
}