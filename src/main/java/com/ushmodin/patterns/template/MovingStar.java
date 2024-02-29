package com.ushmodin.patterns.template;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;

public class MovingStar extends MovingObject {
    public MovingStar(Dimension dimension) {
        super(dimension);
    }


    public static Polygon createStar(int arms, Point center, double rOuter, double rInner) {
        double angle = Math.PI / arms;

        Polygon polygon = new Polygon();

        for (int i = 0; i < 2 * arms; i++) {
            double r = (i & 1) == 0 ? rOuter : rInner;
            Point2D.Double p = new Point2D.Double(
                    center.x + Math.cos(i * angle) * r,
                    center.y + Math.sin(i * angle) * r);
            polygon.addPoint((int) p.x, (int) p.y);
        }
        return polygon;
    }

    @Override
    protected void drawBody(Graphics g) {
        var star = createStar(5,new Point(ax.get(),ay.get()),10,30);
        g.drawPolygon(star);
    }

    @Override
    protected void setColor(Graphics g) {
        g.setColor(Color.RED);
    }
}
