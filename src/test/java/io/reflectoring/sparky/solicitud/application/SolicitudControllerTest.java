package io.reflectoring.sparky.solicitud.application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import io.reflectoring.sparky.usuario.service.UsuarioService;
import io.reflectoring.sparky.solicitud.dto.SolicitudResponseDTO;

@WebMvcTest(SolicitudController.class)
class SolicitudControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private UsuarioService usuarioService;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void getHistoryEndpoint_returnsJsonList() throws Exception {
        SolicitudResponseDTO dto = SolicitudResponseDTO.builder()
                .id(1L)
                .consulta("Hola")
                .respuesta("Mundo")
                .modelo("gpt-4")
                .tokensConsumidos(10)
                .fechaHora(LocalDateTime.now())
                .build();
        when(usuarioService.getSolicitudHistory(42L)).thenReturn(List.of(dto));

        mvc.perform(get("/api/ai/history/42"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(List.of(dto))));
    }
}