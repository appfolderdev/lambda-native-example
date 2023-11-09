package com.example;

import jakarta.inject.Singleton;

@Singleton
public class SimpleService {

    public String sayHello(String to){
        return "hey " + to;
    }
}
