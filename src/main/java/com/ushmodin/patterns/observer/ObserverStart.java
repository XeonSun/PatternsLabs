package com.ushmodin.patterns.observer;

import javax.swing.*;

public class ObserverStart {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Observer");
        frame.setContentPane(new Scene().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
