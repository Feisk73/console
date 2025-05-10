package org.feisk73.consoleApp.commands;

import org.feisk73.consoleApp.ConsoleMain;

public abstract class CommandBase implements Command {
    protected final ConsoleMain main;

    public CommandBase(ConsoleMain main) {
        this.main = main;
    }
}
