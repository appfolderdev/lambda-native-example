package com.hello;

import io.micronaut.runtime.Micronaut;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
//        ApplicationContext context =
                Micronaut.build(args)
                .eagerInitSingletons(true)
                .mainClass(Application.class)
                .start();

//        SimpleService service = context.getBean(SimpleService.class);
//        String result = service.sayHello("jonas@arlequim.com.br");
//        System.out.println(result);
    }

}