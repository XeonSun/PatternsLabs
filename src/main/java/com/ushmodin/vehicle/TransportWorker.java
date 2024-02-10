package com.ushmodin.vehicle;

import com.ushmodin.patterns.decorator.SyncronizedTransport;
import com.ushmodin.patterns.factoryMethod.AutoFactory;
import com.ushmodin.patterns.factoryMethod.TransportFactory;
import com.ushmodin.vehicle.exception.DuplicateModelNameException;
import com.ushmodin.vehicle.exception.ModelPriceOutOfBoundsException;
import com.ushmodin.vehicle.exception.NoSuchModelNameException;

public class TransportWorker {

    private static TransportFactory factory = new AutoFactory();

    public static void setFactory(TransportFactory factory) {
        TransportWorker.factory = factory;
    }


    public static double printAverage(Transport transport) {
        double res = 0;
        for (double i : transport.getModelPrices()) {
            res += i;
        }
        return res / transport.getModelsSize();
    }

    public static void printModelsNames(Transport transport) {
        System.out.println(transport.getBrand() + " содержит модели c именем:");
        for (var i : transport.getModelNames()) {
            System.out.println(i);
        }
    }

    public static void printModelsPrises(Transport transport) {
        System.out.println(transport.getBrand() + " содержит модели с ценой:");
        for (var i : transport.getModelPrices()) {
            System.out.println(i);
        }
    }


    //нет необходимости во всех методах ниже

    public static void addModel(Transport transport, String name, double price) {
        try {
            transport.addModel(name, price);
        } catch (DuplicateModelNameException e) {
            System.out.println(e.getMessage());
        } catch (ModelPriceOutOfBoundsException e2) {
            System.out.println(e2.getMessage());
        }
    }

    public static void deleteModel(Transport transport, String name, double price) {
        try {
            transport.deleteModel(name, price);
        } catch (NoSuchModelNameException e) {
            System.out.println(e.getMessage());
        } catch (ModelPriceOutOfBoundsException e2) {
            System.out.println(e2.getMessage());
        }
    }

    public static void changeName(Transport transport, String name, String newName) {
        try {
            transport.changeName(name, newName);
        } catch (DuplicateModelNameException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchModelNameException e2) {
            System.out.println(e2.getMessage());
        }
    }

    public static void setModelPrice(Transport transport, String name, double price) {
        try {
            transport.setModelPrice(name, price);
        } catch (NoSuchModelNameException e) {
            System.out.println(e.getMessage());
        } catch (ModelPriceOutOfBoundsException e2) {
            System.out.println(e2.getMessage());
        }
    }

    public static Transport createInstance(String name, int size) {
        return factory.createInstance(name, size);
    }

    public static Transport synchronizedTransport(Transport transport) {
        return new SyncronizedTransport(transport);
    }

}
