package com.ushmodin.patterns.observer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

public class Mouth extends JLabel implements Subject {
    private final List<Observer> observers = new LinkedList<Observer>();

    private ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    private ImageIcon[] icons = new ImageIcon[2];

    static final String MOUTH = "face/mouth.png";
    static final String SMILE = "face/smile.png";

    private boolean state = true;

    public Mouth() {
        super();
        icons[0] = new ImageIcon(classloader.getResource(MOUTH));
        icons[1] = new ImageIcon(classloader.getResource(SMILE));

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
        state = !state;
        setIcon(icons[state ?0:1]);
    }

}
