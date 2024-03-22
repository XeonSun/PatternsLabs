package com.ushmodin.patterns.mvc;

import javax.swing.*;
import java.awt.*;

public class MVCstart {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MVC");
        frame.setSize(400,400);
        frame.setContentPane(new Scene().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }}
