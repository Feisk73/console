package org.feisk73.consoleApp.commands;

public interface Command {
    void execute(String[] args);
    String getDescription();
}
