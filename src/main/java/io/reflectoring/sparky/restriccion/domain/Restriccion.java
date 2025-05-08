package io.reflectoring.sparky.restriccion.domain;

import io.reflectoring.sparky.empresa.domain.Empresa;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Entidad que representa una restricción de uso de un modelo para una empresa.
 */
@Entity
@Table(name = "restricciones_empresa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restriccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Empresa a la que aplica la restricción.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    /**
     * Identificador del modelo (e.g., "openai-chat", "meta-multimodal").
     */
    @Column(name = "tipo_modelo", nullable = false)
    private String tipoModelo;

    /**
     * Número máximo de solicitudes permitidas en la ventana de tiempo.
     */
    @Column(name = "max_solicitudes")
    private Long maxSolicitudes;

    /**
     * Número máximo de tokens permitidos en la ventana de tiempo.
     */
    @Column(name = "max_tokens")
    private Long maxTokens;

    /**
     * Duración de la ventana de tiempo en segundos.
     */
    @Column(name = "ventana_tiempo_segundos", nullable = false)
    private Long ventanaTiempoSegundos;

    /**
     * Marca de tiempo de creación.
     */
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    /**
     * Marca de tiempo de última actualización.
     */
    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion = LocalDateTime.now();

    @PreUpdate
    private void onUpdate() {
        this.fechaActualizacion = LocalDateTime.now();
    }
}
