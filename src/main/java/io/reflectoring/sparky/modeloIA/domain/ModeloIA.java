package io.reflectoring.sparky.modeloIA.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "modelos_ia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModeloIA {

    @Id
    @Column(nullable = false, unique = true)
    private String nombre;
}