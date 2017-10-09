package com.pattern.proxy.example001;

public class ProxySubject implements Subject{
    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void doSomething() {
        System.out.println(this.getClass().getName()+" before do something...");
        subject.doSomething();
        System.out.println(this.getClass().getName()+" after do something...");
    }
}
