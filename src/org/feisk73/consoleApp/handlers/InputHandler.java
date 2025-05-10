package org.feisk73.consoleApp.handlers;

import org.feisk73.consoleApp.ConsoleMain;
import org.feisk73.consoleApp.UI.InputPanel;

import javax.swing.*;
import java.util.Locale;

public class InputHandler {
    private final ConsoleMain main;
    public InputHandler(ConsoleMain main) {
        this.main = main;
    }
    public void handleThis(String text) {
        System.out.println(text);
        JTextField field = main.getConsolePanel().getInputPanel().getInputField();
        main.getConsolePanel().getLogPanel().printOutput(field.getText(), true);
        field.setText("");

        main.getCommandHandler().executeCommand(text.toLowerCase());
    }
}
    