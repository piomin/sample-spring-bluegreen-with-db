package pl.piomin.samples.spring.bluegreen.caller;

import io.specto.hoverfly.junit.core.Hoverfly;
import io.specto.hoverfly.junit5.HoverflyExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import static io.specto.hoverfly.junit.core.SimulationSource.dsl;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(HoverflyExtension.class)
@AutoConfigureTestRestTemplate
public class CallerControllerTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void callmeIntegration(Hoverfly hoverfly) {
        hoverfly.simulate(
                dsl(service("http://person:8080")
                        .get("/persons/1")
                        .willReturn(success().body("{\"id\":1}")))
        );
        String response = restTemplate.getForObject("/caller/call", String.class);
        assertEquals("{\"id\":1}", response);
    }
}
