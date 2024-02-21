package com.ushmodin.patterns.observer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Nose extends JLabel implements Subject {
    private final List<Observer> observers = new LinkedList<Observer>();

    private ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    static final String PATH = "face/nose.png";

    private BufferedImage image;

    private Random rand = new Random();

    public Nose() {
        super();
        try {
            image = ImageIO.read(classloader.getResource(PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setIcon(new ImageIcon(image));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                notifyObservers();
            }

        });
    }

    @Override
    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void updateState() {
        int color = rand.nextInt(Integer.MAX_VALUE)+1;
        for(int y = 0; y < image.getHeight(); y++)
            for(int x = 0; x < image.getWidth(); x++)
            {
                if(image.getRGB(x,y) != 0)
                    image.setRGB(x, y, color);
            }
        setIcon(new ImageIcon(image));
    }
}
