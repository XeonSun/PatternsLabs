package com.ushmodin.patterns.observer;

import java.util.LinkedList;
import java.util.List;

public interface Subject {
    List<Observer> getObservers();

    void attachObserver(Observer observer);
    void detachObserver(Observer observer);

    void updateState();


    //Java 8 default
    default void notifyObservers(){
        var obs = getObservers();
        if(obs != null && !obs.isEmpty()) {
            obs.forEach(observer -> observer.update(this));
            printMsg();
        }
    }

    //Java 9 private
    private static void printMsg(){
        System.out.println("Observers notified");
    }
}
