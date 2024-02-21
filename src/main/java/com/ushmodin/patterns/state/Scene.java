package com.ushmodin.patterns.state;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scene {
    private JPanel panel1;
    private JButton sembutton1;
    private JButton holButton;
    private JButton sesButton;
    private JPanel student;

    public Scene() {
        sembutton1.addActionListener(e -> ((Student) student).sem());
        holButton.addActionListener(e ->((Student) student).holiday());
        sesButton.addActionListener(e -> ((Student) student).exam());
    }

    public Container getPanel() {
        return  panel1;
    }

    private void createUIComponents() {
        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(600,512));
        student = new Student();
    }
}
