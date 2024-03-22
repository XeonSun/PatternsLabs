package com.ushmodin.patterns.dao;

import com.ushmodin.vehicle.Auto;
import com.ushmodin.vehicle.Transport;
import com.ushmodin.vehicle.exception.DuplicateModelNameException;

import java.io.*;

/*
Brand ....
Model1 (name ,price)
Model2
...
ModelN
 */
public class TextFile implements DAO {
    private final String fileName;

    public TextFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(Transport transport) {
        try (PrintWriter pr = new PrintWriter(fileName)) {
            pr.println(transport.getBrand());
            int n = transport.getModelsSize();
            String[] names = transport.getModelNames();
            double[] prices = transport.getModelPrices();
            for (int i = 0; i < n; i++) {
                pr.printf("%s;%f\n", names[i], prices[i]);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transport load() {
        Transport res = new Auto("", 0);
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            res.setBrand(br.readLine());
            br.lines().sequential().map(l -> l.split(";")).forEach(arr -> {
                String name = arr[0];
                double price = Double.parseDouble(arr[1]);
                try {
                    res.addModel(name,price);
                } catch (DuplicateModelNameException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
