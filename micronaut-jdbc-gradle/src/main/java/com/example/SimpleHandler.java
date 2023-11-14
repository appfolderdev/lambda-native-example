package com.example;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import io.micronaut.function.aws.MicronautRequestHandler;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleHandler extends MicronautRequestHandler<SQSEvent, String> {

    @Inject
    private SimpleService service;

    private static Logger logger = LoggerFactory.getLogger(SimpleHandler.class);

    @Override
    public String execute(SQSEvent input) {
        String msg = service.sayHello(input.getRecords().get(0).getBody());
        logger.info(msg);
        return msg;
    }
}
