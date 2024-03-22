package com.ushmodin.patterns.dao;

import com.ushmodin.vehicle.Transport;

import java.io.*;

public class BinaryFile implements DAO{

    private final String fileName;

    public BinaryFile(String filename) {
        this.fileName = filename;
    }

    @Override
    public void save(Transport transport) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(transport);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transport load() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Transport) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
