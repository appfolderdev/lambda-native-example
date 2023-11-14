package com.hello;

import io.micronaut.runtime.Micronaut;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        Micronaut.build(args)
                .eagerInitSingletons(true)
                .mainClass(Application.class)
                .start();
    }

}