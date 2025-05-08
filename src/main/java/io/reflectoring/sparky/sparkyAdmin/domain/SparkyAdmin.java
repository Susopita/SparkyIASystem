package io.reflectoring.sparky.sparkyAdmin.domain;

import io.reflectoring.sparky.usuario.domain.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sparky_admins")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SparkyAdmin extends Usuario {
    private Long empresaId;
}
