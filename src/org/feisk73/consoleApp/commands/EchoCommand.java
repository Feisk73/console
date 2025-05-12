package org.feisk73.consoleApp.commands;

import org.feisk73.consoleApp.ConsoleMain;

public class EchoCommand extends CommandBase implements Command {
        public EchoCommand(ConsoleMain main) {
        super(main);
    }

    @Override
    public void execute(String[] args) {
        StringBuilder output = new StringBuilder();
        for (String string :
                args) {
            output.append(string);
            output.append(' ');
        }
        print(output.toString());
    }

    @Override
    public String getDescription() {
        return "returns the given string";
    }
}
