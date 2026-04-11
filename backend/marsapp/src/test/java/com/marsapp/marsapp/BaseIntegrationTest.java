package com.marsapp.marsapp;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.postgresql.PostgreSQLContainer;

public abstract class BaseIntegrationTest {

    public static final PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:16-alpine");

    static {
        postgres.start();
    }

    @ServiceConnection
    static PostgreSQLContainer getPostgres() {
        return postgres;
    }
}
