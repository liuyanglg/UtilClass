package com.synchronize.example01;

public class SynchronizedTest {
    private static int x = 0;
    private static int y = 0;

    public static synchronized void showX(String threadName, int i) {
        SynchronizedTest.x = i;
        System.out.println(threadName + ", setX: " + (x));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static  void showY(String threadName, int i) {
        SynchronizedTest.y = i;
        System.out.println(threadName + ", setY: " + (y));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadTest test = new ThreadTest();
            test.setCounter(i);
            test.start();
        }
    }
}
