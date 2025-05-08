package io.reflectoring.sparky.limite.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.reflectoring.sparky.limite.domain.Limite;

@Repository
public interface LimiteRepository extends JpaRepository<Limite, Long> {
}
