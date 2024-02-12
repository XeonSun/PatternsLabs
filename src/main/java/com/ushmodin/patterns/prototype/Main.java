package com.ushmodin.patterns.prototype;

import com.ushmodin.patterns.factoryMethod.MotocycleFactory;
import com.ushmodin.vehicle.Transport;
import com.ushmodin.vehicle.TransportWorker;

public class Main {
    public static void main(String[] args){
        Transport a = TransportWorker.createInstance("auto",5);
        Transport b = a.clone();
        b.setBrand("b");
        TransportWorker.changeName(b,"default0","New");
        TransportWorker.printModelsNames(a);
        TransportWorker.printModelsNames(b);
        TransportWorker.setFactory(new MotocycleFactory());
        a = TransportWorker.createInstance("moto",5);
        b = a.clone();
        b.setBrand("b");
        TransportWorker.changeName(b,"default0","New");
        TransportWorker.printModelsNames(a);
        TransportWorker.printModelsNames(b);
    }
}
