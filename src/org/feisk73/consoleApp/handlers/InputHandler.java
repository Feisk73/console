package org.feisk73.consoleApp.handlers;

import org.feisk73.consoleApp.ConsoleMain;

import javax.swing.*;

public class InputHandler {
    private final ConsoleMain main;
    public InputHandler(ConsoleMain main) {
        this.main = main;
    }
    public void handleThis(String text) {
        JTextField field = main.getConsolePanel().getInputPanel().getInputField();
        main.getConsolePanel().getLogPanel().printOutput(field.getText(), true);
        field.setText("");

        main.getCommandHandler().executeCommand(text.toLowerCase());
    }
}
