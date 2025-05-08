package io.reflectoring.sparky.sparkyAdmin.application;

import io.reflectoring.sparky.sparkyAdmin.domain.SparkyAdmin;
import io.reflectoring.sparky.sparkyAdmin.domain.SparkyAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sparky-admins")
public class SparkyAdminController {
    private final SparkyAdminService service;

    public SparkyAdminController(SparkyAdminService service) {
        this.service = service;
    }

    @GetMapping
    public List<SparkyAdmin> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SparkyAdmin getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SparkyAdmin create(@RequestBody SparkyAdmin sparkyAdmin) {
        return service.create(sparkyAdmin);
    }

    @PutMapping("/{id}")
    public SparkyAdmin update(@PathVariable Long id, @RequestBody SparkyAdmin sparkyAdmin) {
        return service.update(id, sparkyAdmin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
