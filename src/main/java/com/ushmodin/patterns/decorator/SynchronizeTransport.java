package com.ushmodin.patterns.decorator;

import com.ushmodin.vehicle.Transport;
import com.ushmodin.vehicle.exception.DuplicateModelNameException;
import com.ushmodin.vehicle.exception.NoSuchModelNameException;

public class SynchronizeTransport implements TransportDecorator,Cloneable {
    private Transport instance;
    public SynchronizeTransport(Transport transport) {
        instance = transport;
    }

    @Override
    public synchronized String getBrand() {
        return instance.getBrand();
    }

    @Override
    public synchronized void setBrand(String brand) {
       instance.setBrand(brand);
    }

    @Override
    public synchronized void changeName(String name, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        instance.changeName(name,newName);
    }

    @Override
    public synchronized String[] getModelNames() {
        return instance.getModelNames();
    }

    @Override
    public synchronized double getModelPrice(String name) throws NoSuchModelNameException {
        return instance.getModelPrice(name);
    }

    @Override
    public synchronized void setModelPrice(String name, double newPrice) throws NoSuchModelNameException {
        instance.setModelPrice(name,newPrice);
    }

    @Override
    public synchronized double[] getModelPrices() {
        return instance.getModelPrices();
    }

    @Override
    public synchronized void addModel(String name, double price) throws DuplicateModelNameException {
        instance.addModel(name,price);
    }

    @Override
    public synchronized void deleteModel(String name, double price) throws NoSuchModelNameException {
        instance.deleteModel(name,price);
    }

    @Override
    public synchronized int getModelsSize() {
        return instance.getModelsSize();
    }

    @Override
    public synchronized Transport clone() {
        return new SyncronizedTransport(instance.clone());
    }
}
