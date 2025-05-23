package io.reflectoring.sparky.restriccion.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RestriccionResponseDTO {
    private Long id;
    private Long empresaId;
    private String tipoModelo;
    private Long maxSolicitudes;
    private Long maxTokens;
    private Long ventanaTiempoSegundos;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
