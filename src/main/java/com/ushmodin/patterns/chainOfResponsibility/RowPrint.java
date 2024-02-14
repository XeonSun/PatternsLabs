package com.ushmodin.patterns.chainOfResponsibility;

import com.ushmodin.vehicle.Transport;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class RowPrint implements PrintHandler{
    private PrintHandler nextHandler;
    private String path;
    public RowPrint(String path) {
        this.path = path;
    }

    @Override
    public void setNextHandler(PrintHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void print(Transport transport) {
        if(transport.getModelsSize() <= 3) {
            try(var fos = new PrintWriter(path)) {
                Arrays.stream(transport.getModelNames()).map(item -> item + ' ').forEach(fos::print);
                fos.println();
            }catch (IOException e){
                System.out.println("I/O Exception :-(");
            }
        }else nextHandler.print(transport);
    }
}
