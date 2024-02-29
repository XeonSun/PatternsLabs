package com.ushmodin.patterns.template;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MovingObject extends JPanel implements Runnable{
    protected final AtomicInteger ax = new AtomicInteger(0);
    protected final AtomicInteger ay = new AtomicInteger(0);
    protected   final AtomicInteger dx =  new AtomicInteger(5);
    protected   final AtomicInteger dy =  new AtomicInteger(3);


    private Dimension dimension;

    public MovingObject(Dimension dimension) {
        this.dimension =  dimension;
        Random r = new Random();
        dx.set(r.nextInt(20));
        dy.set(r.nextInt(20));
        setPreferredSize(dimension);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public void paintComponent(Graphics g) {
        setColor(g);
        drawBody(g);
    }

    protected abstract void drawBody(Graphics g);

    protected abstract void setColor(Graphics g);

    @Override
    public void run() {
        while (true){
            int w = 10;
            int h = 10;
            int x = ax.get();
            int y = ay.get();
            x += dx.get();
            if (x > dimension.width - w) {
                x = dimension.width - w;
                dx.updateAndGet(v -> -v);
            }
            if (x < 0) {
                x = 0;
                dx.updateAndGet(v -> -v);
            }
            y += dy.get();
            if (y > dimension.height - h) {
                y = dimension.width - h;
                dy.updateAndGet(v -> -v);
            }
            if (y < 0) {
                y = 0;
                dy.updateAndGet(v -> -v);
            }

            ax.set(x);
            ay.set(y);
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
