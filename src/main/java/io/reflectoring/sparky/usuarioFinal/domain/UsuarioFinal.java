package io.reflectoring.sparky.usuarioFinal.domain;

import java.util.List;

import io.reflectoring.sparky.limite.domain.Limite;
import io.reflectoring.sparky.solicitud.domain.Solicitud;
import io.reflectoring.sparky.usuario.domain.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario_final")
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")
public class UsuarioFinal extends Usuario {

    @OneToMany(mappedBy = "usuario_final")
    private List<Solicitud> solicitudes;

    @OneToMany(mappedBy = "usuario_final")
    private List<Limite> limites;
}
