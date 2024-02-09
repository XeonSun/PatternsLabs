package com.ushmodin.patterns.factoryMethod;

import com.ushmodin.vehicle.Motorcycle;
import com.ushmodin.vehicle.Transport;

public class MotocycleFactory implements TransportFactory{
    public MotocycleFactory(){

    }
    public Transport createInstance(String mark, int size) {
        return new Motorcycle(mark,size);
    }
}
