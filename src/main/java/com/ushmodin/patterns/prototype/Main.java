package com.ushmodin.patterns.prototype;

import com.ushmodin.patterns.factoryMethod.MotocycleFactory;
import com.ushmodin.vehicle.Transport;
import com.ushmodin.vehicle.TransportWorker;

public class Main {
    public static void main(String[] args){
        TransportWorker.setFactory(new MotocycleFactory());
        Transport a = TransportWorker.createInstance("a",5);
        Transport b = a.clone();
        b.setBrand("b");
        TransportWorker.changeName(b,"default0","New");
        TransportWorker.printModelsNames(a);
        TransportWorker.printModelsNames(b);
    }
}
