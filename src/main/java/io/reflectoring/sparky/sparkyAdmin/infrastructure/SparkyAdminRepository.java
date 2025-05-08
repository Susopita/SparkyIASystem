package io.reflectoring.sparky.sparkyAdmin.infrastructure;

import io.reflectoring.sparky.sparkyAdmin.domain.SparkyAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparkyAdminRepository extends JpaRepository<SparkyAdmin, Long> {

}