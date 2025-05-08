package io.reflectoring.sparky.solicitud.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import io.reflectoring.sparky.usuario.domain.Usuario;
import io.reflectoring.sparky.empresa.domain.Empresa;
import lombok.*;

@Entity
@Table(name = "solicitudes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String consulta;

    @Column(columnDefinition = "TEXT")
    private String respuesta;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer tokensConsumidos;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @ElementCollection
    @CollectionTable(
            name = "solicitud_archivos",
            joinColumns = @JoinColumn(name = "solicitud_id")
    )
    @Column(name = "archivo_nombre")
    private List<String> archivos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;
}