package com.pattern.factory.example001;

public class MiPhone implements Phone {
    public void call() {
        System.out.println("use mi6 call");
    }

    public void watchVideo() {
        System.out.println("use mi6 watch video");
    }

    public void playGame() {
        System.out.println("use mi6 play game");
    }

    public void pay() {
        System.out.println("use mi pay");
    }
}
