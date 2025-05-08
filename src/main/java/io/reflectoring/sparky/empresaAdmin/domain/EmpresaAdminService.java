package io.reflectoring.sparky.empresaAdmin.domain;

import io.reflectoring.sparky.empresaAdmin.infrastructure.EmpresaAdminRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar la lógica de negocio de los administradores de empresa.
 * Implementa operaciones CRUD y consultas específicas sin interfaz separada.
 */
@Service
@Transactional
public class EmpresaAdminService {

    private final EmpresaAdminRepository repository;

    /**
     * Constructor para inyección de dependencias.
     */
    public EmpresaAdminService(EmpresaAdminRepository repository) {
        this.repository = repository;
    }

    /**
     * Crea un nuevo administrador de empresa.
     * @param admin datos del administrador a crear
     * @return el administrador persistido
     */
    public EmpresaAdmin create(EmpresaAdmin admin) {
        return repository.save(admin);
    }

    /**
     * Obtiene todos los administradores de empresa registrados.
     * @return lista de administradores
     */
    @Transactional(readOnly = true)
    public List<EmpresaAdmin> findAll() {
        return repository.findAll();
    }

    /**
     * Busca un administrador por su ID.
     * @param id identificador del administrador
     * @return Optional con el administrador si existe
     */
    @Transactional(readOnly = true)
    public Optional<EmpresaAdmin> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Busca un administrador por su email.
     * @param email correo electrónico del admin
     * @return Optional con el administrador si existe
     */
    @Transactional(readOnly = true)
    public Optional<EmpresaAdmin> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    /**
     * Busca el administrador principal de una empresa.
     * @param empresaId ID de la empresa
     * @return Optional con el administrador si existe
     */
    @Transactional(readOnly = true)
    public Optional<EmpresaAdmin> findByEmpresaId(Long empresaId) {
        return repository.findByEmpresaId(empresaId);
    }

    /**
     * Actualiza los datos de un administrador existente.
     * @param id identificador del admin
     * @param adminDetails nuevos datos a actualizar
     * @return el administrador actualizado
     */
    public EmpresaAdmin update(Long id, EmpresaAdmin adminDetails) {
        EmpresaAdmin existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EmpresaAdmin not found id=" + id));
        existing.setEmail(adminDetails.getEmail());
        existing.setNombre(adminDetails.getNombre());
        existing.setPassword(adminDetails.getPassword());
        existing.setEmpresa(adminDetails.getEmpresa());
        // No cambiamos role ni flags aquí.
        return repository.save(existing);
    }

    /**
     * Desactiva un administrador de empresa (borrado lógico).
     * @param id identificador del admin
     */
    public void delete(Long id) {
        EmpresaAdmin existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EmpresaAdmin not found id=" + id));
        existing.setActivo(false);
        repository.save(existing);
    }
}
