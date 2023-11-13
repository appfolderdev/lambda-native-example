package com.hello;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.context.annotation.Value;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Properties;

import static java.text.MessageFormat.format;

@Prototype
public class SimpleService {

    private static final Logger logger = LoggerFactory.getLogger(SimpleService.class);

    @Value("${DATASOURCES_DEFAULT_URL}")
    private String url;

    @Value("${DATASOURCES_DEFAULT_USERNAME}")
    private String user;

    @Value("${DATASOURCES_DEFAULT_PASSWORD}")
    private String pass;

    public String sayHello(String to) throws SQLException {
        logger.info("buscando usuario: " + to);
        String name;
        try (
                SessionFactory connection = getConnection();
                Session session = connection.openSession()
        ) {
            session.beginTransaction();
            UserEntity user = session.find(UserEntity.class, Long.valueOf(to));
            if (user == null) {
                name = "not found";
            } else {
                name = user.getName();
                logger.info(" usuario encontrado: " + name);
            }
            session.getTransaction().commit();
        }

        return "hey " + name;
    }

    private SessionFactory getConnection() {
        logger.info(format("iniciando conexão com o bd {0}...", url));

        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", url);
        prop.setProperty("hibernate.connection.username", user);
        prop.setProperty("hibernate.connection.password", pass);
        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.default_schema", "vdi");
        prop.setProperty("hibernate.hbm2ddl.auto", "none");
        //prop.setProperty("hibernate.connection.provider_class", "com.zaxxer.hikari.hibernate.HikariConnectionProvider");

        SessionFactory sessionFactory = new Configuration()
                .addProperties(prop)
                .addAnnotatedClass(UserEntity.class)
                .buildSessionFactory();

        logger.info("conexão estabelecida!");
        return sessionFactory;
    }
}
