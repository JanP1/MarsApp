package com.marsapp.marsapp.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.web.servlet.client.RestTestClient;
// import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;

import com.marsapp.marsapp.BaseIntegrationTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Testcontainers
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
public class RoverDataControllerTest {

    // @Container
    // @ServiceConnection
    // static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:16-alpine");

    @ServiceConnection
    static PostgreSQLContainer postgres = BaseIntegrationTest.postgres;

    @LocalServerPort
    private int port;

    @Autowired
    private RestTestClient restTestClient;

    @Autowired
    private RoverDataRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void shoudlFindLatestRoverPosition() {

        RoverData rover = new RoverData();
        rover.setSol(101);
        rover.setLongitude(-5);
        rover.setLattitude(-75);
        repository.save(rover);

        restTestClient.get()
                .uri("/api/rover/position/latest")
                .exchange()
                .expectStatus().isOk()
                .expectBody(RoverData.class)
                .consumeWith(response -> {
                    RoverData body = response.getResponseBody();
                    assertThat(body).isNotNull();
                    assertThat(body.getSol()).isEqualTo(101);
                });
    }

    @Test
    void shouldReturn404WhenSolNotFound() {
        restTestClient.get()
            .uri("/api/rover/position/latest")
            .exchange()
            .expectStatus().isNotFound()
            .expectBody(String.class)
            .consumeWith(result -> {

                String message = result.getResponseBody();
                assertThat(message).contains("Data for sol not found");
            });
    }   


}


