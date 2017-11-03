package com.pattern.command;

public class TvChangeChannelCommand implements Command {
    private Tv tv;
    private int channel;

    public TvChangeChannelCommand(Tv tv, int channel) {
        this.tv = tv;
        this.channel = channel;
    }

    public void execute() {
        tv.changeChannel(channel);
    }
}
