package io.reflectoring.sparky.solicitud.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import io.reflectoring.sparky.solicitud.domain.Solicitud;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitudResponseDTO {
    private Long id;
    private String consulta;
    private String respuesta;
    private String modelo;
    private Integer tokensConsumidos;
    private LocalDateTime fechaHora;
    private List<String> archivos;

    public static SolicitudResponseDTO fromEntity(Solicitud s) {
        return SolicitudResponseDTO.builder()
                .id(s.getId())
                .consulta(s.getConsulta())
                .respuesta(s.getRespuesta())
                .modelo(s.getModelo())
                .tokensConsumidos(s.getTokensConsumidos())
                .fechaHora(s.getFechaHora())
                .archivos(s.getArchivos())
                .build();
    }
}