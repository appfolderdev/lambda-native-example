package com.hello;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final SimpleService handler;

    @Get("/demo")
    public HttpResponse<?> demo() throws SQLException {
        String result = handler.sayHello("jonas@arlequim.com.br");
        return HttpResponse.ok(result);
    }

}