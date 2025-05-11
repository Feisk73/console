package org.feisk73.consoleApp.UI;

import org.feisk73.consoleApp.ConsoleMain;
import org.feisk73.consoleApp.listeners.InputListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputPanel extends JPanel {
    private final ConsoleMain main;
    private final JButton submitBtn;
    private final JTextField inputField;
    private int cmdSelected = 0;

    public InputPanel(ConsoleMain main) {
        this.main = main;
        setLayout(new BorderLayout(5, 5));
        submitBtn = new JButton();
        inputField = new JTextField();

        submitBtn.setContentAreaFilled(false);
        submitBtn.setOpaque(true);
        submitBtn.setBackground(Color.darkGray);
        submitBtn.setForeground(Color.white);

        submitBtn.setFont(main.getFont());
        inputField.setFont(main.getFont());

        submitBtn.setText("Send");

        add(submitBtn, BorderLayout.WEST);
        add(inputField, BorderLayout.CENTER);

        submitBtn.addActionListener(new InputListener(main));
        inputField.addActionListener(new InputListener(main));
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String[] cmds = main.getConsolePanel().getLogPanel().extractCommands();
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    if (cmdSelected + 1 <= cmds.length) {
                        cmdSelected++;
                        inputField.setText(cmds[cmds.length - cmdSelected]);
                    }
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    if (cmdSelected - 1 > 0) {
                        cmdSelected--;
                        inputField.setText(cmds[cmds.length - cmdSelected]);
                    }
                }
            }
        });
    }

    public JTextField getInputField() {
        return inputField;
    }

    public void setCmdSelected(int cmdSelected) {
        this.cmdSelected = cmdSelected;
    }
}
