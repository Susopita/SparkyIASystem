package io.reflectoring.sparky.restriccion.dto;

import lombok.Data;

@Data
public class RestriccionRequestDTO {
    private String tipoModelo;
    private Long maxSolicitudes;
    private Long maxTokens;
    private Long ventanaTiempoSegundos;
}
