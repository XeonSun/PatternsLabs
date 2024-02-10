package com.ushmodin.patterns.facade.traffic;

import java.awt.*;
import java.awt.image.ImageObserver;

class TrafficLight {
    protected void paintComponent(Graphics g, ImageObserver observer) {
        g.fillOval(100,100,50,50);
    }
}
