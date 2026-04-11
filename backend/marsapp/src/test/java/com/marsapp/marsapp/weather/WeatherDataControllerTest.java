package com.marsapp.marsapp.weather;

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
public class WeatherDataControllerTest {

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
    private WeatherDataAvgRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void shoudlFindLatestWeatherDataAvg() {

        WeatherDataAvg day = new WeatherDataAvg();
        day.setSol(101);
        day.setHigh(-5);
        day.setLow(-75);
        repository.save(day);

        restTestClient.get()
                .uri("/api/weather/latest")
                .exchange()
                .expectStatus().isOk()
                .expectBody(WeatherDataAvg.class)
                .consumeWith(response -> {
                    WeatherDataAvg body = response.getResponseBody();
                    assertThat(body).isNotNull();
                    assertThat(body.getSol()).isEqualTo(101);
                });
    }
    @Test
    void shouldReturn404WhenSolNotFound() {
        restTestClient.get()
            .uri("/api/weather/latest")
            .exchange()
            .expectStatus().isNotFound()
            .expectBody(String.class)
            .consumeWith(result -> {

                String message = result.getResponseBody();
                assertThat(message).contains("Data for sol not found");
            });
    }   
}


