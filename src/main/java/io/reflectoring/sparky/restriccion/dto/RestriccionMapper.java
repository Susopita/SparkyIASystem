package io.reflectoring.sparky.restriccion.dto;

import io.reflectoring.sparky.restriccion.domain.Restriccion;
import io.reflectoring.sparky.empresa.domain.Empresa;

public class RestriccionMapper {

    public static Restriccion toEntity(RestriccionRequestDTO dto, Empresa empresa) {
        return Restriccion.builder()
                .empresa(empresa)
                .tipoModelo(dto.getTipoModelo())
                .maxSolicitudes(dto.getMaxSolicitudes())
                .maxTokens(dto.getMaxTokens())
                .ventanaTiempoSegundos(dto.getVentanaTiempoSegundos())
                .build();
    }

    public static RestriccionResponseDTO toDTO(Restriccion restriccion) {
        RestriccionResponseDTO dto = new RestriccionResponseDTO();
        dto.setId(restriccion.getId());
        dto.setEmpresaId(restriccion.getEmpresa().getId());
        dto.setTipoModelo(restriccion.getTipoModelo());
        dto.setMaxSolicitudes(restriccion.getMaxSolicitudes());
        dto.setMaxTokens(restriccion.getMaxTokens());
        dto.setVentanaTiempoSegundos(restriccion.getVentanaTiempoSegundos());
        dto.setFechaCreacion(restriccion.getFechaCreacion());
        dto.setFechaActualizacion(restriccion.getFechaActualizacion());
        return dto;
    }
}
