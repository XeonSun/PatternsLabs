package com.ushmodin.patterns.facade.traffic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.*;

class Car {
    private final BufferedImage[] image = new BufferedImage[2];
    private int frame = 0;

    private int xPos = 0;
    private int yPos = 0;
    private int direction = 10;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private boolean moving = true;

    private Dimension dimension;

    public Car(Dimension dimension) {
        this.dimension =  dimension;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            image[0] = scaleImage( ImageIO.read(classloader.getResourceAsStream("AE86.png")));
            image[1] = mirrorImage(image[0]);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        yPos = dimension.height-image[0].getHeight();
    }


    private static BufferedImage scaleImage(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(2, 2);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(image, null);
    }

    private static BufferedImage mirrorImage(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(image, null);
    }

    public int getCenterPos() {
        return xPos+image[0].getWidth()/2;
    }

    protected void paintComponent(Graphics g, ImageObserver observer) {
        if(moving){
            xPos += direction;
            if (xPos + image[0].getWidth() > dimension.width) {
                xPos = dimension.width - image[0].getWidth();
                direction *= -1;
                frame++;
            } else if (xPos < 0) {
                xPos = 0;
                direction *= -1;
                frame--;
            }
        }
        g.drawImage(image[frame], xPos, yPos, observer);
    }

}
