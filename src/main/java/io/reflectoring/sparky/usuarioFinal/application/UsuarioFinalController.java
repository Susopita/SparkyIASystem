package io.reflectoring.sparky.usuarioFinal.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reflectoring.sparky.modeloIA.domain.ModeloIA;
import io.reflectoring.sparky.solicitud.domain.Solicitud;
import io.reflectoring.sparky.usuarioFinal.domain.UsuarioFinalService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class UsuarioFinalController {
    private final UsuarioFinalService usuarioFinalService;

    // POST /api/ai/chat
    @PostMapping("/chat")
    public ResponseEntity<String> consultaChat(@RequestBody String consulta, @RequestParam String nombreIA) {
        return ResponseEntity.ok(usuarioFinalService.consultaChat(consulta));
    }

    // POST /api/ai/completion
    @PostMapping("/completion")
    public ResponseEntity<String> consultaCompletacion(@RequestBody String consulta, @RequestParam String nombreIA) {
        return ResponseEntity.ok(usuarioFinalService.consultaCompletacion(consulta));
    }

    // POST /api/ai/multimodal
    @PostMapping("/multimodal")
    public ResponseEntity<String> consultaMultimodal(@RequestBody String consulta, @RequestParam String nombreIA) {
        return ResponseEntity.ok(usuarioFinalService.consultaMultimodal(consulta));
    }

    // GET /api/ai/models
    @GetMapping("/models")
    public ResponseEntity<List<ModeloIA>> obtenerModelos() {
        return ResponseEntity.ok(usuarioFinalService.obtenerModelos());
    }

    // GET /api/ai/history
    @GetMapping("/history")
    public ResponseEntity<List<Solicitud>> obtenerHistorial() {
        return ResponseEntity.ok(usuarioFinalService.obtenerHistorial());
    }

}
