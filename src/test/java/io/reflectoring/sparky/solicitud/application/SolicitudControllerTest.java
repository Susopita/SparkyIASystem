package io.reflectoring.sparky.solicitud.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import io.reflectoring.sparky.usuarioFinal.domain.UsuarioFinalService;
import io.reflectoring.sparky.solicitud.dto.SolicitudResponseDTO;

@ExtendWith(MockitoExtension.class)
class SolicitudControllerTest {
    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Mock
    private UsuarioFinalService usuarioFinalService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(new SolicitudController(usuarioFinalService)).build();
    }

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
        when(usuarioFinalService.getSolicitudHistory(42L)).thenReturn(List.of(dto));

        mvc.perform(get("/api/ai/history/42"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(List.of(dto))));
    }
}
