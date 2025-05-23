package org.feisk73.consoleApp.commands;

import org.feisk73.consoleApp.ConsoleMain;

public abstract class CommandBase implements Command {
    protected final ConsoleMain main;

    public CommandBase(ConsoleMain main) {
        this.main = main;
    }
    public void print(String text) {
        main.getConsolePanel().getLogPanel().printOutput(text, false);
    }
    public void printf(String text, Object... args) {
        print(String.format(text, args));
    }
}
