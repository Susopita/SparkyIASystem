package io.reflectoring.sparky.modeloIA.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.reflectoring.sparky.modeloIA.domain.ModeloIA;

@Repository
public interface ModeloIARepository extends JpaRepository<ModeloIA, String> {
}