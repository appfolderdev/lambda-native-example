package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final SimpleService handler;

    @Get("/demo")
    public HttpResponse<?> demo() {

        String result = handler.sayHello("jonas@arlequim.com.br");
        return HttpResponse.ok(result);
    }

}