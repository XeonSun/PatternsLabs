package com.ushmodin.patterns.facade.traffic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Scene extends JPanel {
    public static final Dimension DIMENSION = new Dimension(1000, 300);
    private Car car;
    private TrafficLight trafficLight;

    Scene() {
        car = new Car(DIMENSION);
        trafficLight = new TrafficLight(DIMENSION);

        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.setMoving(Math.abs(car.getCenterPos()-DIMENSION.width/2)>=DIMENSION.width/10 || trafficLight.getState()>0);
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
