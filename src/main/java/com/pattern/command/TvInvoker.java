package com.pattern.command;

public class TvInvoker {
    private TvOnCommand tvOnCommand;
    private TvOffCommand tvOffCommand;

    private TvChangeChannelCommand tvChangeChannelCommand;

    public TvInvoker(TvOnCommand tvOnCommand, TvOffCommand tvOffCommand, TvChangeChannelCommand tvChangeChannelCommand) {
        this.tvOnCommand = tvOnCommand;
        this.tvOffCommand = tvOffCommand;
        this.tvChangeChannelCommand = tvChangeChannelCommand;
    }

    public void on(){
        tvOnCommand.execute();
    }

    public void off(){
        tvOffCommand.execute();
    }

    public void changeChannel(){
        tvChangeChannelCommand.execute();
    }
}
