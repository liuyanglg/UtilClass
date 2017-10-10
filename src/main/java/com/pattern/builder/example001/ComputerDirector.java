package com.pattern.builder.example001;

public class ComputerDirector {
    ComputerBuilder builder = null;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer construct(){
        builder.buildCpu();
        builder.buildMemory();
        builder.buildDisk();
        builder.buildScreen();
        builder.buildPower();
        builder.buildKeyboard();
        builder.buildMouse();
        return builder.buildComputer();
    }
}
