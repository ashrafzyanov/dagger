package com.ashrafzyanov.app.command;

public interface Command {

    void execute();

    String getActive();

    String getCommandName();

}
