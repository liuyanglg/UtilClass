package com.synchronize.example01;

public class ThreadTest extends Thread {
    private int counter;

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
//            SynchronizedTest.showX(Thread.currentThread().getName(),counter);
//            System.out.println( Thread.currentThread().getName()+ ",getX: " + SynchronizedTest.getX());
            SynchronizedTest.showY(Thread.currentThread().getName(),counter);
//            System.out.println( Thread.currentThread().getName()+ ", getY: " + SynchronizedTest.getY());
        }
    }
}
