package com.ushmodin.patterns.command;

import com.ushmodin.vehicle.Auto;
import com.ushmodin.vehicle.TransportWorker;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            var auto = new Auto("Car",2);
            auto.setCommand(new RowPrint());
            auto.print(new FileWriter("testCommand.txt"));
            auto.setCommand(new ColPrint());
            auto.print(new FileWriter("testCommand2.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
