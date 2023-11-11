package com.hello;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.text.MessageFormat.format;

@Factory
public class ConnectionConfig {

    @Value("${DATASOURCES_DEFAULT_URL}")
    private String url;

    @Value("${DATASOURCES_DEFAULT_USERNAME}")
    private String user;

    @Value("${DATASOURCES_DEFAULT_PASSWORD}")
    private String pass;

    private static Logger logger = LoggerFactory.getLogger(ConnectionConfig.class);

    @Bean
    @Singleton
    public Connection getConnection() throws SQLException {
        logger.info(format("iniciando conexão com o bd {0}...", url));
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            logger.error("erro na conexçao", e);
            throw e;
        }
        logger.info("conexão estabelecida!");
        return connection;
    }

}
