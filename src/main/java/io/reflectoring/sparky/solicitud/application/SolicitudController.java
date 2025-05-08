package io.reflectoring.sparky.solicitud.application;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.reflectoring.sparky.solicitud.infrastructure.SolicitudRepository;
import io.reflectoring.sparky.solicitud.dto.SolicitudResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ai/history")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudRepository repository;

    /**
     * Obtiene el historial de solicitudes para un usuario dado.
     * TODO: Reemplazar la obtención de userId con el usuario autenticado.
     */
    @GetMapping("/{userId}")
    public List<SolicitudResponseDTO> getHistory(@PathVariable Long userId) {
        return repository.findByUsuarioId(userId)
                .stream()
                .map(SolicitudResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
}