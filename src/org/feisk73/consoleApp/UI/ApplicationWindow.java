package org.feisk73.consoleApp.UI;

import javax.swing.*;

public class ApplicationWindow {
    private final String WINDOW_NAME = "Консоль";

    private final int WINDOW_WIDTH = 640;
    private final int WINDOW_HEIGHT = 400;


    private JFrame frame = new JFrame(WINDOW_NAME);

    public void initialize() {
        frameInitialize();
    }

    private void frameInitialize() {
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public int getWINDOW_HEIGHT() {
        return WINDOW_HEIGHT;
    }

    public String getWINDOW_NAME() {
        return WINDOW_NAME;
    }

    public int getWINDOW_WIDTH() {
        return WINDOW_WIDTH;
    }
}
