package com.lock.model;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *Created by  liuya
 *2017/12/25
 */
public class People {
    private int age;
    private String name;

    private ReadWriteLock lock=new ReentrantReadWriteLock();

    public int getAge() {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get: " + age);
        }finally {
            lock.readLock().unlock();
        }
        return age;
    }

    public void setAge(int age) {
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " set: " + age);
            this.age = age;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
