package com.hello;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import io.micronaut.function.aws.MicronautRequestHandler;
import jakarta.inject.Inject;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleHandler extends MicronautRequestHandler<SQSEvent, String> {

    @Inject
    private SimpleService service;
    private static Logger logger = LoggerFactory.getLogger(SimpleHandler.class);

    @Override
    @SneakyThrows
    public String execute(SQSEvent input) {
        logger.info("evento recebido...");
        SQSEvent.SQSMessage sqsMessage = input.getRecords().get(0);
        String body = sqsMessage.getBody();
        return service.sayHello(body);
    }
}
