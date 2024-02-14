package com.ushmodin.patterns.chainOfResponsibility;

import com.ushmodin.vehicle.Transport;

public interface PrintHandler {
    void setNextHandler(PrintHandler handler);
    void print(Transport transport);
}
