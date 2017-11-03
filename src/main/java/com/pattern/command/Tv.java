package com.pattern.command;

public class Tv {
    private int channel;
    public void on(){
        System.out.println("the tv is on");
    }

    public void off(){
        System.out.println("the tv is off");
    }

    public void changeChannel(int channel){
        this.channel = channel;
        System.out.println("the current channel is "+ channel);
    }
}
