package com.hello;

import io.micronaut.runtime.Micronaut;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

    public static void main(String[] args) {
        log.info("Starting application");
//        Micronaut.run(Application.class, args);

        Micronaut.build(args)
                .eagerInitSingletons(true)
                .mainClass(Application.class)
                .start();

    }


}