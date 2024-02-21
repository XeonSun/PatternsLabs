package com.ushmodin.patterns.observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Eye extends JLabel implements Subject {
    private final List<Observer> observers = new LinkedList<Observer>();

    private ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    private ImageIcon[] icons = new ImageIcon[2];

    static final String EYE_PATH = "face/eye.png";
    static final String EYE_CLOSED_PATH = "face/eye_closed.png";

    private boolean open = true;

    public Eye() {
        super();
        icons[0] = new ImageIcon(classloader.getResource(EYE_PATH));
        icons[1] = new ImageIcon(classloader.getResource(EYE_CLOSED_PATH));

        setIcon(icons[0]);
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
        open = !open;
        setIcon(icons[open?0:1]);
    }

}
