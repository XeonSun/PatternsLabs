package com.ushmodin.patterns.visitor;

import com.ushmodin.patterns.command2.ModelPrinter;
import com.ushmodin.vehicle.Auto;
import com.ushmodin.vehicle.Motorcycle;

import java.io.OutputStreamWriter;

public class PrintVisitor implements Visitor{

    @Override
    public void visit(Auto auto) {
        ModelPrinter.printRow(auto);
    }

    @Override
    public void visit(Motorcycle motorcycle) {
        ModelPrinter.printCol(motorcycle);
    }
}
