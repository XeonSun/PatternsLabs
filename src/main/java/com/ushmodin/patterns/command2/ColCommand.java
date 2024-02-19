package com.ushmodin.patterns.command2;

import com.ushmodin.vehicle.Transport;

import java.io.Writer;

public class ColCommand implements Command {
    private Writer writer;
    private Transport transport;

    public ColCommand(Writer writer, Transport transport) {
        this.writer = writer;
        this.transport = transport;
    }

    @Override
    public void execute() {
        ModelPrinter.printCol(writer,transport);
    }
}
