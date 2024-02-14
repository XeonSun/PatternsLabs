package com.ushmodin.patterns.chainOfResponsibility;

import com.ushmodin.vehicle.Transport;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class ColPrint implements PrintHandler{
    private PrintHandler nextHandler;
    private String path;
    public ColPrint(String path) {
        this.path = path;
    }

    @Override
    public void setNextHandler(PrintHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void print(Transport transport) {
        if(transport.getModelsSize() > 3) {
            try(var fos = new PrintWriter(path)) {
                Arrays.stream(transport.getModelNames()).forEach(fos::println);
            }catch (IOException e){
                System.out.println("I/O Exception :-(");
            }
        }else nextHandler.print(transport);
    }
}
