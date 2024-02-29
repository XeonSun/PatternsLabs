package com.ushmodin.patterns.template;

import java.awt.*;

public class MovingBox extends MovingObject {
    public MovingBox(Dimension dimension) {
        super(dimension);
    }

    @Override
    protected void drawBody(Graphics g) {
        g.drawRect(ax.get(),ay.get(),50,50);
    }

    @Override
    protected void setColor(Graphics g) {
        g.setColor(Color.RED);
    }
}
