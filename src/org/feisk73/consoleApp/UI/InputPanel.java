package org.feisk73.consoleApp.UI;

import org.feisk73.consoleApp.listeners.InputListener;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    private final ConsolePanel main;
    private JButton submitBtn;
    private JTextField inputField;
    public InputPanel(ConsolePanel main) {
        this.main = main;
        setLayout(new BorderLayout(5,5));
        submitBtn = new JButton();
        inputField = new JTextField();

        submitBtn.setFont(main.getMain().getFont());
        inputField.setFont(main.getMain().getFont());

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
