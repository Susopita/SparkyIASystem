package io.reflectoring.sparky.usuarioFinal.domain;

import java.util.List;

import io.reflectoring.sparky.solicitud.domain.Solicitud;
import io.reflectoring.sparky.usuario.domain.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarioFinal")
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "id")
public class UsuarioFinal extends Usuario {

    @OneToMany(mappedBy = "usuarioFinal")
    private List<Solicitud> solicitudes;
}
