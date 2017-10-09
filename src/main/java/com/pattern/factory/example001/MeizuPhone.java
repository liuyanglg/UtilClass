package com.pattern.factory.example001;

public class MeizuPhone implements Phone{
    public void call() {
        System.out.println("use MX7 x call");
    }

    public void watchVideo() {
        System.out.println("use MX7 x watch video");
    }

    public void playGame() {
        System.out.println("use MX7 x play game");
    }

    public void pay() {
        System.out.println("use meizu pay");
    }
}
