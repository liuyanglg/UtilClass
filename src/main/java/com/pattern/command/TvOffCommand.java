package com.pattern.command;

public class TvOffCommand implements  Command{
    private Tv tv;

    public TvOffCommand(Tv tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.off();
    }
}
