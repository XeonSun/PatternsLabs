package com.ushmodin.patterns.command2;

import com.ushmodin.vehicle.Transport;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;

public class ModelPrinter {
    public static void printCol (Writer writer, Transport transport) {
        try(var printWriter = new PrintWriter(writer)) {
            Arrays.stream(transport.getModelNames()).forEach(printWriter::println);
            printWriter.println();
        }
    }
    public static void printCol (Transport transport) {
            Arrays.stream(transport.getModelNames()).forEach(System.out::println);
            System.out.println();
    }
    public static void printRow (Writer writer, Transport transport) {
        try(var printWriter = new PrintWriter(writer)) {
            Arrays.stream(transport.getModelNames()).map(item -> item + ' ').forEach(printWriter::print);
            printWriter.println();
        }
    }
    public static void printRow (Transport transport) {
            Arrays.stream(transport.getModelNames()).map(item -> item + ' ').forEach(System.out::print);
            System.out.println();
    }
}
