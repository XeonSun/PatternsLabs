package com.ushmodin.patterns.command2;

import com.ushmodin.vehicle.Transport;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;

public class ModelPrinter {
    public static void printCol (Writer writer, Transport transport) {
        try(var fos = new PrintWriter(writer)) {
            Arrays.stream(transport.getModelNames()).forEach(fos::println);
            fos.println();
        }
    }

    public static void printRow (Writer writer, Transport transport) {
        try(var fos = new PrintWriter(writer)) {
            Arrays.stream(transport.getModelNames()).map(item -> item + ' ').forEach(fos::print);
            fos.println();
        }
    }
}
