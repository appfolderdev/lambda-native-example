package com.hello;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import io.micronaut.function.aws.MicronautRequestHandler;
import jakarta.inject.Inject;
import lombok.SneakyThrows;

public class SimpleHandler extends MicronautRequestHandler<SQSEvent, String> {

    @Inject
    private SimpleService service;

    @Override
    @SneakyThrows
    public String execute(SQSEvent input) {
        SQSEvent.SQSMessage sqsMessage = input.getRecords().get(0);
        String body = sqsMessage.getBody();
        return service.sayHello(body);
    }
}
