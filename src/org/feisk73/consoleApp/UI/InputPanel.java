package org.feisk73.consoleApp.UI;

import org.feisk73.consoleApp.ConsoleMain;
import org.feisk73.consoleApp.listeners.InputListener;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    private final ConsoleMain main;
    private final JButton submitBtn;
    private final JTextField inputField;
    public InputPanel(ConsoleMain main) {
        this.main = main;
        setLayout(new BorderLayout(5,5));
        submitBtn = new JButton();
        inputField = new JTextField();

        submitBtn.setFont(main.getFont());
        inputField.setFont(main.getFont());

        add(submitBtn, BorderLayout.WEST);
        add(inputField, BorderLayout.CENTER);

        submitBtn.addActionListener(new InputListener(main));
        inputField.addActionListener(new InputListener(main));
    }

    public JButton getSubmitBtn() {
        return submitBtn;
    }

    public JTextField getInputField() {
        return inputField;
    }
}
