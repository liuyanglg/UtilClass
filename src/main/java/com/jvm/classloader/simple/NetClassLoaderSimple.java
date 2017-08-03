package com.jvm.classloader.simple;

public class NetClassLoaderSimple {
    private NetClassLoaderSimple instance;

    public void setInstance(Object obj) {
        this.instance = (NetClassLoaderSimple) obj;
    }
}
