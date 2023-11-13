package com.example;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class SimpleService {

    @Inject
    private UserRepository repository;

    private static Logger logger = LoggerFactory.getLogger(SimpleService.class);

    public String sayHello(String to) {
        logger.info("buscando usuario: " + to);
        UserEntity user = repository.findByEmail(to).orElse(null);
        return "hey " + user.getName();
    }
}
