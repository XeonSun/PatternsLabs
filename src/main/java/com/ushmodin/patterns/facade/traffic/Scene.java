package com.ushmodin.patterns.facade.traffic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;


class Scene extends JPanel {
    public static final Dimension DIMENSION = new Dimension(500, 300);
    private Car car;
    private TrafficLight trafficLight;

    Scene() {
        car = new Car();
        trafficLight = new TrafficLight();

        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }

        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return DIMENSION;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        trafficLight.paintComponent(g,this);
        car.paintComponent(g,this);
    }
}
