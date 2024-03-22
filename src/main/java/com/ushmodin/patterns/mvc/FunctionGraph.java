package com.ushmodin.patterns.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Comparator;

public class FunctionGraph extends JPanel {
    final private Model model;

    public FunctionGraph(Model model) {
        super();
        this.model = model;    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = this.getWidth() / 2;
        int h = this.getHeight() / 2;
        Graphics2D g1 = (Graphics2D) g;
        g1.setStroke(new BasicStroke(2));
        g1.setColor(Color.black);
        g1.drawLine(0, h, w * 2, h);
        g1.drawLine(w, 0, w, h * 2);
        g1.drawString("0", w - 7, h + 13);
        for (int i = w; i < this.getWidth(); i += 10) {
            g1.drawLine(i, h + 3, i, h - 3);
            g1.drawLine(w - (i - w), h + 3, w - (i - w), h - 3);
        }
        for (int i = h; i < this.getHeight(); i += 10) {
            g1.drawLine(w - 3, i, w + 3, i);
            g1.drawLine(w - 3, h - (i - h), w + 3, h - (i - h));

        }
        g1.setColor(Color.RED);
        final Point[] prev = {null};
        Arrays.stream(model.getPoints()).map(p -> new Point((int)p.x+w,(int)-p.y+h)).sorted(Comparator.comparingInt(point -> point.x)).
                forEach(point -> {
                    if(prev[0] != null){
                        g1.drawLine((int) prev[0].x, (int) prev[0].y, (int) point.x, (int) point.y);
                    }
                    prev[0] = point;
                });
    }
}
