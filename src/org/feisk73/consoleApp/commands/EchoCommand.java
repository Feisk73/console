package org.feisk73.consoleApp.commands;

import org.feisk73.consoleApp.ConsoleMain;

import java.util.Arrays;

public class EchoCommand implements Command {
    private final ConsoleMain main;

    public EchoCommand(ConsoleMain main) {
        this.main = main;
    }

    @Override
    public void execute(String[] args) {
        StringBuilder output = new StringBuilder();
        for (String string :
                args) {
            output.append(string);
            output.append(' ');
        }
        main.output(output.toString());
    }

    @Override
    public String getDescription() {
        return "returns the given string";
    }
}
