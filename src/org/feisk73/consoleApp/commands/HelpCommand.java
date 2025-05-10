package org.feisk73.consoleApp.commands;
import org.feisk73.consoleApp.ConsoleMain;
import org.feisk73.consoleApp.handlers.CommandHandler;

public class HelpCommand implements Command {
    private final ConsoleMain main;
    public HelpCommand(ConsoleMain main) {
        this.main = main;
    }

    @Override
    public void execute(String[] args) {
        String output = main.getCommandHandler().commandList();
        main.getConsolePanel().getLogPanel().printOutput(output, false);
    }

    @Override
    public String getDescription() {
        return "returns a list of all console.commands with descriptions";
    }
}
