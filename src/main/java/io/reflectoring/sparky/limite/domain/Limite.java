package io.reflectoring.sparky.limite.domain;

import io.reflectoring.sparky.modeloIA.domain.ModeloIA;
import io.reflectoring.sparky.restriccion.domain.Restriccion;
import io.reflectoring.sparky.usuarioFinal.domain.UsuarioFinal;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Limite {

    @ManyToOne
    @JoinColumn(name = "usuario_final_id")
    private UsuarioFinal usuarioFinal;

    @OneToOne
    @JoinColumn(name = "modelo_ia_nombre")
    private ModeloIA modeloIA;

    private Restriccion restriccion;
}
