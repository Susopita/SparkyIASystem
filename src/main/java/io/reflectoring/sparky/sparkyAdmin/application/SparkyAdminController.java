package io.reflectoring.sparky.sparkyAdmin.application;

import io.reflectoring.sparky.sparkyAdmin.domain.SparkyAdmin;
import io.reflectoring.sparky.sparkyAdmin.domain.SparkyAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas/{empresaId}/administradores")
public class SparkyAdminController {
    private final SparkyAdminService service;

    public SparkyAdminController(SparkyAdminService service) {
        this.service = service;
    }

    // GET /api/empresas/{empresaId}/administradores
    @GetMapping
    public ResponseEntity<List<SparkyAdmin>> getAll(@PathVariable Long empresaId) {
        List<SparkyAdmin> list = service.findAll(empresaId);
        return ResponseEntity.ok(list);
    }

    // GET /api/empresas/{empresaId}/administradores/{adminId}
    @GetMapping("/{adminId}")
    public ResponseEntity<SparkyAdmin> getById(@PathVariable Long empresaId,
                                               @PathVariable Long adminId) {
        SparkyAdmin admin = service.findById(empresaId, adminId);
        return ResponseEntity.ok(admin);
    }

    // POST /api/empresas/{empresaId}/administradores
    @PostMapping
    public ResponseEntity<SparkyAdmin> create(@PathVariable Long empresaId,
                                              @RequestBody SparkyAdmin sparkyAdmin) {
        SparkyAdmin created = service.create(empresaId, sparkyAdmin);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT /api/empresas/{empresaId}/administradores/{adminId}
    @PutMapping("/{adminId}")
    public ResponseEntity<SparkyAdmin> update(@PathVariable Long empresaId,
                                              @PathVariable Long adminId,
                                              @RequestBody SparkyAdmin sparkyAdmin) {
        SparkyAdmin updated = service.update(empresaId, adminId, sparkyAdmin);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/empresas/{empresaId}/administradores/{adminId}
    @DeleteMapping("/{adminId}")
    public ResponseEntity<Void> delete(@PathVariable Long empresaId,
                                       @PathVariable Long adminId) {
        service.delete(empresaId, adminId);
        return ResponseEntity.noContent().build();
    }
}

