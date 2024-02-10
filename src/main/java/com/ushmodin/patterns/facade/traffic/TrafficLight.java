package com.ushmodin.patterns.facade.traffic;

import java.awt.*;
import java.awt.image.ImageObserver;

class TrafficLight {
    private static final int RADIUS = 50;
    private static final int LIGHT_RADIUS = 40;
    private static final int STAGE_TIME = 100;
    private Dimension dimension;
    private int xPos = 0;
    private int yPos = 0;

    private int time = 0;

    public int getState() {
        return state;
    }

    private int state = 0;




    public TrafficLight(Dimension dimension) {
        this.dimension = dimension;
        xPos = (dimension.width)/2-RADIUS/2;
    }

    protected void paintComponent(Graphics g, ImageObserver observer) {
        time++;
        g.fillOval( xPos, yPos, RADIUS, RADIUS);
        g.fillOval( xPos, yPos+ RADIUS, RADIUS, RADIUS);
        g.fillOval( xPos, yPos+ RADIUS *2, RADIUS, RADIUS);
        state = time/100%3;
        switch (state){
            case 0:
                g.setColor(Color.RED);
                g.fillOval( xPos+5, yPos+5, LIGHT_RADIUS,LIGHT_RADIUS);
            break;
            case 1:
                g.setColor(Color.YELLOW);
                g.fillOval( xPos+5, yPos+ RADIUS+5, LIGHT_RADIUS, LIGHT_RADIUS);
            break;
            case 2:
                g.setColor(Color.GREEN);
                g.fillOval( xPos+5, yPos+ RADIUS *2+5, LIGHT_RADIUS,LIGHT_RADIUS);
            break;
        }

    }
}
