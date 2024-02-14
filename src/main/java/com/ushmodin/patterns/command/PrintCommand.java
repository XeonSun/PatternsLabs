package com.ushmodin.patterns.command;

import com.ushmodin.vehicle.Transport;

import java.io.PrintStream;
import java.io.Writer;

public interface PrintCommand {
    void print (Writer writer, Transport transport);
}
