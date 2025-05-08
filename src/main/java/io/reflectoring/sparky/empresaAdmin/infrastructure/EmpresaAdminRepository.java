package io.reflectoring.sparky.empresaAdmin.infrastructure;

import io.reflectoring.sparky.empresaAdmin.domain.EmpresaAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaAdminRepository extends JpaRepository<EmpresaAdmin, Long> {

    Optional<EmpresaAdmin> findByEmail(String email);

    Optional<EmpresaAdmin> findByEmpresaId(Long empresaId);
}