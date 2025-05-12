package org.feisk73.consoleApp;

import org.feisk73.consoleApp.UI.ApplicationWindow;
import org.feisk73.consoleApp.UI.ConsolePanel;
import org.feisk73.consoleApp.commands.*;
import org.feisk73.consoleApp.handlers.CommandHandler;
import org.feisk73.consoleApp.handlers.InputHandler;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ConsoleMain {
    private final ApplicationWindow window = new ApplicationWindow();
    private final ConsolePanel consolePanel;
    private final Font font = new Font("Consolas", Font.PLAIN, 14);
    private final InputHandler inputHandler;
    private final CommandHandler commandHandler;

    public ConsoleMain() {
        consolePanel = new ConsolePanel(this);
        inputHandler = new InputHandler(this);
        commandHandler = new CommandHandler();

        commandHandler.registerCommand("help", new HelpCommand(this));
        commandHandler.registerCommand("echo", new EchoCommand(this));
        commandHandler.registerCommand("calc", new CalcCommand(this));
        commandHandler.registerCommand("clear", new ClearCommand(this));
        commandHandler.registerCommand("ping", new PingCommand(this));
        commandHandler.registerCommand("time", new TimeCommand(this));
        commandHandler.registerCommand("random", new RandomCommand(this));

        window.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                consolePanel.getInputPanel().getInputField().requestFocusInWindow();
            }
        });

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
