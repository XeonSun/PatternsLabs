package com.ushmodin.patterns.proxy;

public class ProxyMultiplier implements Multipiler{
    private final ServerMultiplier serverMultiplier;
    public ProxyMultiplier() {
        this.serverMultiplier = new ServerMultiplier();
    }

    @Override
    public double mult(double a, double b) {
        if(!Double.isFinite(a)||!Double.isFinite(b))
            throw new RuntimeException("Invalid args");
        return serverMultiplier.mult(a,b);
    }
}
