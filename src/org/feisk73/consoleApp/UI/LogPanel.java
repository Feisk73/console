package org.feisk73.consoleApp.UI;

import org.feisk73.consoleApp.ConsoleMain;

import javax.swing.*;
import java.awt.*;

public class LogPanel extends JPanel {
    private final String START_MSG = "Console started!\n";
    private JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textArea);
    private ConsolePanel main;
    public LogPanel(ConsolePanel main) {
        setLayout(new BorderLayout(5, 5));
        textArea.setText(START_MSG);
        textArea.setFont(main.getMain().getFont());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        add(scrollPane, BorderLayout.CENTER);
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

}
