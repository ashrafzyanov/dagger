package com.ashrafzyanov.testdagger.command;

public interface Command {

    void execute();

    String getActive();

    String getCommandName();

}
