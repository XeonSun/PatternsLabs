package com.ushmodin.patterns.factoryMethod;

import com.ushmodin.vehicle.Transport;

public interface TransportFactory {
    Transport createInstance(String mark, int size);
}
