package com.ushmodin.patterns.command;

import com.ushmodin.vehicle.Transport;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;

public class ColPrint implements PrintCommand{

    @Override
    public void print (Writer writer, Transport transport) {
        try(var fos = new PrintWriter(writer)) {
            Arrays.stream(transport.getModelNames()).forEach(fos::println);
            fos.println();
        }
    }
}
