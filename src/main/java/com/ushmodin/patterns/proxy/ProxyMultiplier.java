package com.ushmodin.patterns.proxy;

public class ProxyMultiplier implements Multipiler{
    private ServerMultiplier serverMultiplier;
    public ProxyMultiplier(){
        //serverMultiplier = new ServerMultiplier();
    }

    @Override
    public double mult(double a, double b) {
        if(!Double.isFinite(a)||!Double.isFinite(b))
            throw new RuntimeException("Invalid args");

        if(serverMultiplier == null)
            serverMultiplier = new ServerMultiplier();

        return serverMultiplier.mult(a,b);
    }
}
