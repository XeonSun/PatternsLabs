package com.ushmodin.patterns.command2;

import com.ushmodin.vehicle.Auto;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            var auto = new Auto("Car",5);

            var invoker = new Invoker();
            invoker.setCommand(new ColCommand(new FileWriter("testCommand.txt"),auto));
            invoker.invoke();

            invoker.setCommand(new RowCommand(new FileWriter("testCommand2.txt"),auto));
            invoker.invoke();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
