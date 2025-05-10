package org.feisk73.consoleApp.listeners;

import org.feisk73.consoleApp.UI.ConsolePanel;
import org.feisk73.consoleApp.handlers.InputHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputListener implements ActionListener {
    private ConsolePanel panel;
    public InputListener(ConsolePanel panel) {
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        panel.getMain().getInputHandler().handleThis(panel.getInputPanel().getInputField().getText());
    }
}

