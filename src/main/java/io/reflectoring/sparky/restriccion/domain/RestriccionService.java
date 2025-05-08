package io.reflectoring.sparky.restriccion.domain;

import io.reflectoring.sparky.restriccion.infrastructure.RestriccionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Servicio para gestionar la lógica de negocio de las restricciones de empresa.
 */
@Service
@Transactional
public class RestriccionService {

    private final RestriccionRepository repository;

    public RestriccionService(RestriccionRepository repository) {
        this.repository = repository;
    }

    /**
     * Crea una nueva restricción para una empresa.
     */
    public Restriccion create(Restriccion restriccion) {
        return repository.save(restriccion);
    }

    /**
     * Lista todas las restricciones de una empresa.
     */
    @Transactional(readOnly = true)
    public List<Restriccion> findAllByEmpresa(Long empresaId) {
        return repository.findAllByEmpresaId(empresaId);
    }

    /**
     * Busca una restricción por ID dentro de una empresa.
     */
    @Transactional(readOnly = true)
    public Restriccion findByIdAndEmpresa(Long id, Long empresaId) {
        return repository.findByIdAndEmpresaId(id, empresaId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Restriccion not found id=" + id + " for empresa=" + empresaId));
    }

    /**
     * Actualiza una restricción existente de la empresa.
     */
    public Restriccion update(Long id, Long empresaId, Restriccion detalles) {
        Restriccion existing = findByIdAndEmpresa(id, empresaId);
        existing.setTipoModelo(detalles.getTipoModelo());
        existing.setMaxSolicitudes(detalles.getMaxSolicitudes());
        existing.setMaxTokens(detalles.getMaxTokens());
        existing.setVentanaTiempoSegundos(detalles.getVentanaTiempoSegundos());
        return repository.save(existing);
    }

    /**
     * Elimina (borrado lógico o físico) una restricción de la empresa.
     */
    public void delete(Long id, Long empresaId) {
        Restriccion existing = findByIdAndEmpresa(id, empresaId);
        repository.delete(existing);
    }
}