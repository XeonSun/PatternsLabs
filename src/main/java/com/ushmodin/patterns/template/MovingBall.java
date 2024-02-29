package com.ushmodin.patterns.template;

import java.awt.*;

public class MovingBall extends MovingObject {
    public MovingBall(Dimension dimension) {
        super(dimension);
        dx.set(10);
    }

    @Override
    protected void drawBody(Graphics g) {
        g.drawOval(ax.get(),ay.get(),50,50);
    }

    @Override
    protected void setColor(Graphics g) {
        g.setColor(Color.RED);
    }
}
