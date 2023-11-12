package com.hello;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Properties;

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
    public SessionFactory getConnection() throws SQLException {
        logger.info(format("iniciando conexão com o bd {0}...", url));

        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", url);
        prop.setProperty("hibernate.connection.username", user);
        prop.setProperty("hibernate.connection.password", pass);
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.default_schema", "vdi");
        prop.setProperty("hibernate.hbm2ddl.auto", "none");

        SessionFactory sessionFactory = new Configuration()
                .addProperties(prop)
                .addAnnotatedClass(UserEntity.class)
                .buildSessionFactory();

        logger.info("conexão estabelecida!");
        return sessionFactory;
    }

}
