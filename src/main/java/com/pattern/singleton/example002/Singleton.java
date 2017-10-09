package com.pattern.singleton.example002;

import java.util.HashSet;

public class Singleton {
    public static HashSet<Singleton> singletons = new HashSet<Singleton>();
    private static volatile Singleton instance = null;

    public Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("懒汉单例模式");
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton s = getInstance();
                    singletons.add(s);
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(singletons.size());
    }
}
