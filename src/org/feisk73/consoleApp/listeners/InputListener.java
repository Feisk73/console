package org.feisk73.consoleApp.listeners;

import org.feisk73.consoleApp.ConsoleMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputListener implements ActionListener {
    private ConsoleMain main;
    public InputListener(ConsoleMain main) {
        this.main = main;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        main.getInputHandler().handleThis(main.getConsolePanel().getInputPanel().getInputField().getText());
    }
}

