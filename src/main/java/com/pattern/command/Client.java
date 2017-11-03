package com.pattern.command;

public class Client {
    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        LightInvoker lightInvoker = new LightInvoker(lightOnCommand, lightOffCommand);
        lightInvoker.on();
        lightInvoker.off();


        Tv tv = new Tv();
        TvOnCommand tvOnCommand = new TvOnCommand(tv);
        TvOffCommand tvOffCommand = new TvOffCommand(tv);
        TvChangeChannelCommand tvChangeChannelCommand = new TvChangeChannelCommand(tv, 2);
        TvInvoker tvInvoker = new TvInvoker(tvOnCommand, tvOffCommand, tvChangeChannelCommand);
        tvInvoker.on();
        tvInvoker.off();
        tvInvoker.changeChannel();
    }
}
