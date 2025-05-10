package org.feisk73.consoleApp.UI;

import org.feisk73.consoleApp.ConsoleMain;
import org.feisk73.consoleApp.handlers.CommandHandler;

import javax.swing.*;
import java.awt.*;

public class LogPanel extends JPanel {
    private final String START_MSG = "Console started!\n";
    private final JTextArea textArea = new JTextArea();
    private ConsoleMain main;
    public LogPanel(ConsoleMain main) {
        this.main = main;
        setLayout(new BorderLayout(5, 5));
        textArea.setText(START_MSG);
        textArea.setFont(main.getFont());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }
    private void addText(String text) {
        textArea.setText(textArea.getText() + "\n" + text);
    }

    public void printOutput(String text, boolean isUser) {
        StringBuilder output = new StringBuilder();
        if (isUser) {
            output.append("> ");
        }
        output.append(text);
        addText(output.toString());
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public String getSTART_MSG() {
        return START_MSG;
    }
}
