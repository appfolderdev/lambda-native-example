package com.example;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

import java.net.MalformedURLException;

public class Application extends AbstractMicronautLambdaRuntime<SQSEvent, String, SQSEvent, String> {

    public static void main(String[] args) throws MalformedURLException {
        new Application().run(args);
    }

    @Override
    protected RequestHandler<SQSEvent, String> createRequestHandler(String... args) {
        return new SimpleHandler();
    }
}