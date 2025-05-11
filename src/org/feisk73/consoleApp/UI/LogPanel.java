package org.feisk73.consoleApp.UI;

import org.feisk73.consoleApp.ConsoleMain;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class LogPanel extends JPanel {
    private final String START_MSG = "Console started!\n";
    private final JTextArea textArea = new JTextArea();
    private final ConsoleMain main;
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
    public String[] extractCommands() {
        return Arrays.stream(textArea.getText().split("\n"))
                .filter(line -> line.startsWith(">"))
                .map(line -> line.substring(1).trim())
                .filter(cmd -> !cmd.isEmpty())
                .toArray(String[]::new);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public String getSTART_MSG() {
        return START_MSG;
    }
}
