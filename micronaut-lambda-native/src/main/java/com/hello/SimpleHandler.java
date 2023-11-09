package com.hello;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SimpleHandler implements RequestHandler<RequestDto, String> {

    @Override
    public String handleRequest(RequestDto s, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("hey " + s.getKey1());
        return "ok";
    }
}
