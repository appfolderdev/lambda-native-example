package com.hello;

import io.micronaut.context.annotation.Prototype;
import jakarta.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Prototype
public class SimpleService {

    @Inject
    private SessionFactory connection;

    private static Logger logger = LoggerFactory.getLogger(SimpleService.class);

    public String sayHello(String to) {
        logger.info("buscando usuario: " + to);
        String name;
        try (Session session = connection.openSession()) {
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
}
