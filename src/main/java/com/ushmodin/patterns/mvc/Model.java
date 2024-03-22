package com.ushmodin.patterns.mvc;

import java.awt.*;
import java.awt.geom.Point2D;

public class Model {

    private Point2D.Double[] points = new Point2D.Double[]{};

    public Point2D.Double[] getPoints() {
        return points;
    }

    private static double func(double x){
        return x*x/100.0;
        //return x;
    }
    public void calcPoints(Point2D.Double[] points){
        for (var p :points) {
            p.y = func(p.x);
        }
        this.points = points;
    }
}
