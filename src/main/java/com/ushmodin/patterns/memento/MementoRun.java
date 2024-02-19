package com.ushmodin.patterns.memento;

import com.ushmodin.vehicle.Auto;
import com.ushmodin.vehicle.TransportWorker;

public class MementoRun {
    public static void main(String[] args){
        Auto a = new Auto("old",3);
        TransportWorker.printModelsNames(a);
        var save = a.createMemento();
        TransportWorker.changeName(a,"default1","new");
        a.setBrand("new");
        TransportWorker.printModelsNames(a);
        a.restoreFromMemento(save);
        TransportWorker.printModelsNames(a);
    }
}
