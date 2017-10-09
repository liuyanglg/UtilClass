package com.pattern.factory.example001;

public class IPhone implements Phone{
    public void call() {
        System.out.println("use iPhone x call");
    }

    public void watchVideo() {
        System.out.println("use iPhone x watch video");
    }

    public void playGame() {
        System.out.println("use iPhone x play game");
    }

    public void pay() {
        System.out.println("use apple pay");
    }
}
