package io.reflectoring.sparky.restriccion.domain;

import io.reflectoring.sparky.empresa.domain.Empresa;
import io.reflectoring.sparky.modeloIA.domain.ModeloIA;
import io.reflectoring.sparky.usuario.domain.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restricciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restriccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "limite_uso", nullable = false)
    private Integer limiteUso;  // Número máximo de solicitudes permitidas

    @Column(name = "tokens_maximos")
    private Integer tokensMaximos;  // Límite opcional de tokens por ventana de tiempo

    @Column(name = "ventana_tiempo", nullable = false)
    private String ventanaTiempo;  // Ejemplo: "1h", "24h", "7d"

    @Column(name = "numero_solicitudes", nullable = false)
    private int numeroSolicitudes;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    // Relación con Empresa (usando RUC como FK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_ruc", referencedColumnName = "ruc", nullable = false)
    private Empresa empresa;

    // Relación con ModeloIA (nombre como FK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modelo_ia_nombre", referencedColumnName = "nombre", nullable = false)
    private ModeloIA modeloIA;

    // Relación con Usuario (opcional, para límites específicos)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
}