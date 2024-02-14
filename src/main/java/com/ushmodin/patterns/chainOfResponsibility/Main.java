package com.ushmodin.patterns.chainOfResponsibility;

import com.ushmodin.vehicle.TransportWorker;

public class Main {
    public static void main(String[] args){
        var chain = new RowPrint("test1.txt");
        chain.setNextHandler(new ColPrint("test2.txt"));

        var transpot = TransportWorker.createInstance("1",2);
        System.out.println(transpot.getBrand());
        chain.print(transpot);

        transpot = TransportWorker.createInstance("2",4);
        System.out.println(transpot.getBrand());
        chain.print(transpot);
    }
}
