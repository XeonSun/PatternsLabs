package com.ushmodin.patterns.visitor;

import com.ushmodin.vehicle.Auto;
import com.ushmodin.vehicle.Motorcycle;
import com.ushmodin.vehicle.Transport;

public interface Visitor {
    void visit(Auto auto);
    void visit(Motorcycle motorcycle);
}
