package com.example.demo.proxy;

public class RealSubject implements Subject {
    @Override
    public void hello(String str) {
        System.out.println("I want to rent my house");
    }

    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }
}
