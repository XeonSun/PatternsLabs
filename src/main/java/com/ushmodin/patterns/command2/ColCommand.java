package com.ushmodin.patterns.command2;

import com.ushmodin.vehicle.Transport;

import java.io.Writer;

public class ColCommand implements Command {
    private Writer writer;
    private Transport transport;

    private ModelPrinter modelPrinter;

    public ColCommand(Writer writer, Transport transport, ModelPrinter modelPrinter) {
        this.writer = writer;
        this.transport = transport;
        this.modelPrinter = modelPrinter;
    }

    @Override
    public void execute() {
        modelPrinter.printCol(writer,transport);
    }
}
