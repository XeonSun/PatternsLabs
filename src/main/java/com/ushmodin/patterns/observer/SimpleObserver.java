package com.ushmodin.patterns.observer;

public class SimpleObserver implements Observer{
    @Override
    public void update(Subject subject) {
        subject.updateState();
        System.out.println("Observed");
    }
}
