package io.reflectoring.sparky.solicitud.infrastructure;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import io.reflectoring.sparky.usuario.domain.Usuario;
import io.reflectoring.sparky.empresa.domain.Empresa;
import io.reflectoring.sparky.solicitud.domain.Solicitud;
import java.util.List;

@DataJpaTest
class SolicitudRepositoryTest {
    @Autowired
    private TestEntityManager em;
    @Autowired
    private SolicitudRepository repo;

    @Test
    void whenFindByUsuarioId_thenReturnSolicitudes() {
        Usuario u = new Usuario();
        u.setNombre("user1");
        u.setPassword("pass1");
        em.persist(u);

        Empresa e = new Empresa();
        e.setNombre("Empresa 1");
        e.setRuc("RUC123");
        e.setActivo(true);
        em.persist(e);

        Solicitud s = Solicitud.builder()
                .consulta("Hola")
                .respuesta("Mundo")
                .modelo("gpt-4")
                .tokensConsumidos(10)
                .fechaHora(LocalDateTime.now())
                .usuario(u)
                .empresa(e)
                .build();
        em.persist(s);
        em.flush();

        List<Solicitud> found = repo.findByUsuarioId(u.getId());
        assertThat(found).hasSize(1);
        assertThat(found.get(0).getConsulta()).isEqualTo("Hola");
    }
}
