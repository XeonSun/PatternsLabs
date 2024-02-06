package com.ushmodin.patterns.factoryMethod;

import com.ushmodin.vehicle.TransportWorker;

public class Main {
    public static void main(String[] args){
        var auto = TransportWorker.createInstance("auto",5);
        TransportWorker.printModelsNames(auto);
        TransportWorker.setFactory(new MotocycleFactory());
        var moto = TransportWorker.createInstance("moto", 5);
        TransportWorker.printModelsNames(moto);
    }
}
