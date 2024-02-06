package com.ushmodin.patterns.factoryMethod;

import com.ushmodin.vehicle.Auto;
import com.ushmodin.vehicle.Transport;

public class AutoFactory implements TransportFactory{
    public AutoFactory(){

    }

    @Override
    public Transport createInstance(String mark, int size) {
        return new Auto(mark,size);
    }
}
