package io.reflectoring.sparky.empresaAdmin.domain;

import io.reflectoring.sparky.auth.domain.Role;
import io.reflectoring.sparky.empresa.domain.Empresa;
import io.reflectoring.sparky.usuario.domain.Usuario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("EMPRESA_ADMIN")
@Getter
@Setter
@NoArgsConstructor
public class EmpresaAdmin extends Usuario {

    @PrePersist
    private void assignDefaultRole() {
        // Aquí sí reconoce Role porque lo importamos arriba
        this.setRole(Role.EMPRESA_ADMIN);
    }

    public EmpresaAdmin(String email,
                        String nombre,
                        String password,
                        Empresa empresa) {
        // invoca el no-arg constructor de Usuario
        super();
        // luego asignas manualmente:
        this.setEmail(email);
        this.setNombre(nombre);
        this.setPassword(password);
        this.setEmpresa(empresa);

        // inicializa también los flags de seguridad
        this.setExpired(false);
        this.setLocked(false);
        this.setCredentialsExpired(false);
        this.setEnable(true);

        // rol se pondrá en @PrePersist o puedes llamarlo aquí
        this.setRole(Role.EMPRESA_ADMIN);
    }
}
