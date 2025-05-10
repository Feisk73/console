package org.feisk73.consoleApp.commands;

import org.feisk73.consoleApp.ConsoleMain;
import org.feisk73.consoleApp.UI.LogPanel;

public class ClearCommand extends CommandBase implements Command {
    public ClearCommand(ConsoleMain main) {
        super(main);
    }

    @Override
    public void execute(String[] args) {
        LogPanel panel = main.getConsolePanel().getLogPanel();
        panel.getTextArea().setText(panel.getSTART_MSG());
    }

    @Override
    public String getDescription() {
        return "clears messages";
    }
}
