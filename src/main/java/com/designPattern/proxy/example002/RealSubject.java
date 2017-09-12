package com.designPattern.proxy.example002;

public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println(RealSubject.class.getName()+" do something...");
    }
}
