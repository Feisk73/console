package org.feisk73.consoleApp.commands;

import org.feisk73.consoleApp.ConsoleMain;

import java.util.Arrays;

public class EchoCommand extends CommandBase implements Command {
        public EchoCommand(ConsoleMain main) {
        super(main);
    }

    @Override
    public void execute(String[] args) {
        String output = Arrays.toString(args);
        print(output.substring(1, output.length()-1));
    }

    @Override
    public String getDescription() {
        return "returns the given string";
    }
}
