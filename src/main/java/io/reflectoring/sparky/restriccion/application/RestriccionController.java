package io.reflectoring.sparky.restriccion.application;

import io.reflectoring.sparky.restriccion.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company/restrictions")
@RequiredArgsConstructor
public class RestriccionController {

    private final RestriccionService restriccionService;

    // Crear nueva restricción
    @PostMapping
    public ResponseEntity<Restriccion> crearRestriccion(@RequestBody Restriccion restriccion) {
        Restriccion creada = restriccionService.create(restriccion);
        return ResponseEntity.ok(creada);
    }

    // Listar todas las restricciones de la empresa
    @GetMapping
    public ResponseEntity<List<Restriccion>> listarRestricciones(@RequestParam Long empresaId) {
        List<Restriccion> restricciones = restriccionService.findAllByEmpresa(empresaId);
        return ResponseEntity.ok(restricciones);
    }

    // Actualizar una restricción
    @PutMapping("/{id}")
    public ResponseEntity<Restriccion> actualizarRestriccion(@PathVariable Long id, @RequestParam Long empresaId, @RequestBody Restriccion restriccion) {
        Restriccion actualizada = restriccionService.update(id, empresaId, restriccion);
        return ResponseEntity.ok(actualizada);
    }

    // Eliminar una restricción
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRestriccion(@PathVariable Long id, @RequestParam Long empresaId) {
        restriccionService.delete(id, empresaId);
        return ResponseEntity.noContent().build();
    }
}
