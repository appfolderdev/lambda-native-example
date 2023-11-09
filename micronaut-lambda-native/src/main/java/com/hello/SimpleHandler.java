package com.hello;

import io.micronaut.function.aws.MicronautRequestHandler;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleHandler extends MicronautRequestHandler<RequestDto, String> {

    @Inject
    private SimpleService service;

    private static Logger logger = LoggerFactory.getLogger(SimpleHandler.class);

    @Override
    public String execute(RequestDto input) {
        logger.info(service.sayHello(input.getKey1()));
        return "ok";
    }
}
