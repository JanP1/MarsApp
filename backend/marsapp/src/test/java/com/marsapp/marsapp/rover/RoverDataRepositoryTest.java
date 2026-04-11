package com.marsapp.marsapp.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
// import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;

import com.marsapp.marsapp.BaseIntegrationTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoverDataRepositoryTest {

    // @Container
    // @ServiceConnection
    // static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:16-alpine");
    @ServiceConnection
    static PostgreSQLContainer postgres = BaseIntegrationTest.postgres;

    @Autowired
    private RoverDataRepository repository;

    @BeforeEach
    void setUp() {

        repository.deleteAll();
    }

    @Test
    void shouldSaveAndRetrieveLatestSol() {
        RoverData day1 = new RoverData();
        day1.setSol(100);
        day1.setLongitude(-10);
        day1.setLattitude(-80);

        RoverData day2 = new RoverData();
        day2.setSol(101);
        day2.setLongitude(-5);
        day2.setLattitude(-75);

        repository.save(day1);
        repository.save(day2);

        Optional<RoverData> latest = repository.findFirstByOrderBySolDesc();

        assertThat(latest).isPresent();
        assertThat(latest.get().getSol()).isEqualTo(101);
        assertThat(latest.get().getLongitude()).isEqualTo(-5);
    }
}
