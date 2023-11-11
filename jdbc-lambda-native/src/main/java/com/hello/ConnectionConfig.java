package com.hello;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Factory
public class ConnectionConfig {

    @Value("${DATASOURCES_DEFAULT_URL}")
    private String url;

    @Value("${DATASOURCES_DEFAULT_USERNAME}")
    private String user;

    @Value("${DATASOURCES_DEFAULT_PASSWORD}")
    private String pass;

    @Bean
    @Singleton
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

}
