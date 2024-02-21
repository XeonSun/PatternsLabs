package com.ushmodin.patterns.state;


import javax.swing.*;

public class StateStart {
    public static void main(String[] args) {
        JFrame frame = new JFrame("State");
        frame.setContentPane(new Scene().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
