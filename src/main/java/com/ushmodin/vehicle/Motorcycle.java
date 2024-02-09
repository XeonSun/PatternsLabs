package com.ushmodin.vehicle;

import com.ushmodin.vehicle.exception.DuplicateModelNameException;
import com.ushmodin.vehicle.exception.ModelPriceOutOfBoundsException;
import com.ushmodin.vehicle.exception.NoSuchModelNameException;

public class Motorcycle implements Transport,Cloneable{
    private String brand;

    private int size = 0;
    private Model head = new Model();

    {
        head.prev = head;
        head.next = head;
    }

    private static class Model{
        private String name = null;
        private double price = Double.NaN;
        private Model prev = null;
        private Model next = null;
    }


    //метод для получения марки мотоцикла
    public String getBrand() {
        return brand;
    }

    //метод для модификации марки мотоцикла
    public void setBrand(String brand) {
        this.brand = brand;
    }

    //Конструктор
    public Motorcycle(String brand, int s) { //int size
        this.brand = brand;
        for (int i = 0; i < s; i++) {
            try {
                addModel("default"+i,0);

            }catch (DuplicateModelNameException e)
            {
                e.printStackTrace();
            }
        }
    }

    //метод для модификации значения названия модел
    //Через имя или значение n?
    public void changeName(String name, String newName) throws NoSuchModelNameException,DuplicateModelNameException {
        if (searchModelByName(newName) == null) {
            getModelByName(name).name = newName;
        } else {
            throw new DuplicateModelNameException(newName);
        }
    }

    //метод, возвращающий массив названий всех моделей
    public String[] getModelNames() {
        String[] names = new String[size];
        Model p = head.next;
        int i = 0;
        while (p != head) {
            names[i] = p.name;
            ++i;
            p = p.next;
        }
        return names;
    }

    //метод для получения значения цены модели по её названию,
    public double getModelPrice(String name) throws NoSuchModelNameException {
        return getModelByName(name).price;
    }

    //метод для модификации значения цены модели по её названию
    public void setModelPrice(String name, double newPrice) throws NoSuchModelNameException {
        if (newPrice < 0) throw new ModelPriceOutOfBoundsException(newPrice);
        getModelByName(name).price = newPrice;
    }

    //метод, возвращающий массив значений цен моделей
    public double[] getModelPrices() {
        double[] prices = new double[size];
        Model p = head.next;
        int i = 0;
        while (p != head) {
            prices[i] = p.price;
            ++i;
            p = p.next;
        }
        return prices;
    }

    //метод добавления названия модели и её цены
    public void addModel(String name, double price) throws DuplicateModelNameException {
        if (price < 0) throw new ModelPriceOutOfBoundsException(price);

        if (searchModelByName(name) != null) {
            throw new DuplicateModelNameException(name);
        } else {
            Model m = new Model();
            m.name = name;
            m.price = price;

            head.prev.next = m;
            m.next = head;
            m.prev = head.prev;
            head.prev = m;
            ++size;
        }
    }

    //метод удаления модели с заданным именем и её цены
    public void deleteModel(String name, double price) throws NoSuchModelNameException {
        if (price < 0) throw new ModelPriceOutOfBoundsException(price);
        Model p = searchModelByName(name);
        if (p != null && p.price == price) {
            p.next.prev = p.prev;
            p.prev.next = p.next;
            p.next = null;
            p.prev = null;
            --size;
        } else {
            throw new NoSuchModelNameException(name);
        }
    }

    public int getModelsSize() {
        return size;
    }

    private Model getModelByName(String name) throws NoSuchModelNameException {
        Model m = head.next;
        while (m != head && !m.name.equals(name)) {
            m = m.next;
        }
        if (m != head)
            return m;
        else
            throw new NoSuchModelNameException(name);
    }

    private Model searchModelByName(String name) {
        Model m = head.next;
        while (m != head && !m.name.equals(name)) {
            m = m.next;
        }
        if (m != head)
            return m;
        else
            return null;
    }

    @Override
    public synchronized Motorcycle clone() {
        try {
            var clone = (Motorcycle) super.clone();

            clone.size = 0;
            clone.head = new Model();
            clone.head.next = clone.head;
            clone.head.prev = clone.head;

            Model p = head.next;
            while (p != head) {
                clone.addModel(p.name,p.price);
                p = p.next;
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        } catch (DuplicateModelNameException e) {
            throw new RuntimeException(e);
        }
    }
}

