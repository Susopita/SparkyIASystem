package io.reflectoring.sparky.sparkyAdmin.domain;

import io.reflectoring.sparky.sparkyAdmin.infrastructure.SparkyAdminRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class SparkyAdminService {
    private final SparkyAdminRepository repository;

    public SparkyAdminService(SparkyAdminRepository repository) {
        this.repository = repository;
    }

    public SparkyAdmin create(Long empresaId, SparkyAdmin sparkyAdmin) {
        return repository.save(sparkyAdmin);
    }

    public List<SparkyAdmin> findAll(Long empresaId) {
        return repository.findAll();
    }

    public SparkyAdmin findById(Long id, Long adminId) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SparkyAdmin not found"));
    }

    public SparkyAdmin update(Long id, Long adminId, SparkyAdmin updated) {
        SparkyAdmin existing = findById(id, adminId);
        existing.setNombre(updated.getUsername());
        existing.setEmail(updated.getEmail());
        existing.setPassword(updated.getPassword());
        existing.setRole(updated.getRole());
        return repository.save(existing);
    }

    public void delete(Long empresaId, Long adminId) {
        SparkyAdmin existing = findById(empresaId, adminId);
        repository.delete(existing);
    }
}
