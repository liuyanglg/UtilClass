package com.pattern.command;

public class TvOnCommand implements  Command{
    private Tv tv;

    public TvOnCommand(Tv tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.on();
    }
}
