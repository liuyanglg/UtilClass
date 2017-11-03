package com.pattern.command;

public class LightInvoker {
    private LightOnCommand lightOnCommand;
    private LightOffCommand lightOffCommand;


    public LightInvoker(LightOnCommand lightOnCommand, LightOffCommand lightOffCommand) {
        this.lightOnCommand = lightOnCommand;
        this.lightOffCommand = lightOffCommand;
    }

    public void on(){
        lightOnCommand.execute();
    }

    public void off(){
        lightOffCommand.execute();
    }
}
