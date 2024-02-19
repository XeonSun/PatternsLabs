package com.ushmodin.patterns.visitor;

import com.ushmodin.patterns.factoryMethod.MotocycleFactory;
import com.ushmodin.vehicle.Transport;
import com.ushmodin.vehicle.TransportWorker;

public class VisitorRun {
    public static void main(String[] args){
        Transport a = TransportWorker.createInstance("a",10);
        TransportWorker.setFactory(new MotocycleFactory());
        Transport b = TransportWorker.createInstance("b",10);
        Visitor v = new  PrintVisitor();
        a.accept(v);
        b.accept(v);
    }

}
