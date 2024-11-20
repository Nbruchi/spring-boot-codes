package com.bruce.example;

import org.springframework.stereotype.Component;

@Component
public class FirstClass {
    private final String myVar;

    public FirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello(){
        return "Hello from FirstClass ==> myVar = " + myVar;
    }
}
