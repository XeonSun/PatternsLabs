package com.ushmodin.patterns.facade.traffic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.*;

class Car {
    private BufferedImage image;
    private BufferedImage mirroredImage;
    private int xPos = 0;
    private int direction = 1;

    public Car() {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            image = ImageIO.read(classloader.getResourceAsStream("AE86.png"));
            mirroredImage = mirrorImage(image);

            System.out.println(image);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static BufferedImage mirrorImage(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(image, null);
    }

    protected void paintComponent(Graphics g, ImageObserver observer) {

        g.drawImage(image, 150, 150, observer);
        g.drawImage(mirroredImage, 150, 50, observer);

    }

}
