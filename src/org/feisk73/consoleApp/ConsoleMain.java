package org.feisk73.consoleApp;

import org.feisk73.consoleApp.UI.ApplicationWindow;
import org.feisk73.consoleApp.UI.ConsolePanel;
import org.feisk73.consoleApp.commands.HelpCommand;
import org.feisk73.consoleApp.handlers.CommandHandler;
import org.feisk73.consoleApp.handlers.InputHandler;

import java.awt.*;

public class ConsoleMain {
    private ApplicationWindow window = new ApplicationWindow();;
    private ConsolePanel consolePanel;
    private Font font = new Font("Consolas", Font.PLAIN, 14);
    private InputHandler inputHandler;
    private CommandHandler commandHandler;

    public ConsoleMain() {
        consolePanel = new ConsolePanel(this);
        inputHandler = new InputHandler(this);
        commandHandler = new CommandHandler();

        commandHandler.registerCommand("help", new HelpCommand(this));

        window.getFrame().add(consolePanel);
        window.initialize();
    }

    public Font getFont() {
        return font;
    }

    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    public ConsolePanel getConsolePanel() {
        return consolePanel;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public ApplicationWindow getWindow() {
        return window;
    }
}
