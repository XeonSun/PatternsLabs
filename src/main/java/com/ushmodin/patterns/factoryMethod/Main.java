package com.ushmodin.patterns.factoryMethod;

import com.ushmodin.vehicle.TransportWorker;

public class Main {
    public static void main(String[] args){
        var auto = TransportWorker.createInstance("auto",5);
        System.out.println(auto.getClass().getName());
        TransportWorker.setFactory(new MotocycleFactory());
        var moto = TransportWorker.createInstance("moto", 5);
        System.out.println(moto.getClass().getName());
    }
}
