package org.feisk73.consoleApp.UI;

import org.feisk73.consoleApp.ConsoleMain;

import javax.swing.*;
import java.awt.*;

public class ConsolePanel extends JPanel {
    private ConsoleMain main;
    private LogPanel logPanel;
    private InputPanel inputPanel;

    public ConsolePanel(ConsoleMain main) {
        this.main = main;
        logPanel = new LogPanel(main);
        inputPanel = new InputPanel(main);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        add(logPanel);
        add(Box.createVerticalStrut(10));
        add(inputPanel);
        add(Box.createVerticalStrut(20));
    }

    public ConsoleMain getMain() {
        return main;
    }

    public InputPanel getInputPanel() {
        return inputPanel;
    }

    public LogPanel getLogPanel() {
        return logPanel;
    }

}