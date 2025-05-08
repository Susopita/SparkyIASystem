package io.reflectoring.sparky.restriccion.infrastructure;

import io.reflectoring.sparky.restriccion.domain.Restriccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestriccionRepository extends JpaRepository<Restriccion, Long> {

    List<Restriccion> findAllByEmpresaId(Long empresaId);

    Optional<Restriccion> findByIdAndEmpresaId(Long id, Long empresaId);
}
