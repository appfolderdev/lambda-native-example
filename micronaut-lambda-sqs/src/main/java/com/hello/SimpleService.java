package com.hello;

import jakarta.inject.Singleton;

@Singleton
public class SimpleService {

    public String sayHello(String to) {
        return "hey " + to + "!";
    }
}
