package com.hello;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller
public class DemoController {

    private final SimpleService handler;

    public DemoController(SimpleService handler) {
        this.handler = handler;
    }

    @Post("/demo")
    public HttpResponse<?> demo(RequestDto req) {
        String result = handler.sayHello(req.getKey1());
        return HttpResponse.ok(result);
    }
}