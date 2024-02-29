package com.ushmodin.patterns.template;


import javax.swing.*;

public class TemplateStart {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Template");
        frame.setContentPane(new Scene().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
