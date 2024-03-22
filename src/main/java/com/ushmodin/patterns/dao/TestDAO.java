package com.ushmodin.patterns.dao;

import com.ushmodin.vehicle.Auto;
import com.ushmodin.vehicle.Transport;
import com.ushmodin.vehicle.TransportWorker;

public class TestDAO {
    public static void main(String[] args) {
        Auto a = new Auto("old",3);
        TransportWorker.printModelsNames(a);

        DAO dao = new BinaryFile("binary.out");
        dao.save(a);
        Transport t = dao.load();
        TransportWorker.printModelsNames(t);

        dao = new TextFile("text.out");
        dao.save(a);
        t = dao.load();
        TransportWorker.printModelsNames(t);

    }
}
