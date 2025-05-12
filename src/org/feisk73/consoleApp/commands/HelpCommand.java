package org.feisk73.consoleApp.commands;
import org.feisk73.consoleApp.ConsoleMain;

public class HelpCommand extends CommandBase implements Command {
    public HelpCommand(ConsoleMain main) {
        super(main);
    }

    @Override
    public void execute(String[] args) {
        String output = main.getCommandHandler().commandList();
        print(output);
    }

    @Override
    public String getDescription() {
        return "returns a list of all console commands with descriptions";
    }
}
