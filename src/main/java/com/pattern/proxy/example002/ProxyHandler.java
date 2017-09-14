package com.designPattern.proxy.example002;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
    private Object proxyObject;

    public ProxyHandler(Subject proxyObject) {
        this.proxyObject = proxyObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(this.getClass().getName()+" before do something...");
        method.invoke(proxyObject, args);
        System.out.println(this.getClass().getName()+" after do something...");
        return null;
    }
}
