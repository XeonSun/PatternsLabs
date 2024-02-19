package com.ushmodin.vehicle;

import com.ushmodin.patterns.command.PrintCommand;
import com.ushmodin.patterns.visitor.Visitor;
import com.ushmodin.vehicle.exception.DuplicateModelNameException;
import com.ushmodin.vehicle.exception.ModelPriceOutOfBoundsException;
import com.ushmodin.vehicle.exception.NoSuchModelNameException;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Auto implements Transport,Cloneable, Serializable,Iterable<Auto.Model>{
    //поле типа String, хранящее марку автомобиля
    private String brand;
    private Model[] models;
    private static final String DEFAULT_NAME = "default";
    private static final double DEFAULT_PRICE = 0.0;
    private PrintCommand command;

    public void setCommand(PrintCommand command) {
        this.command = command;
    }

    //метод для получения марки автомобиля
    public String getBrand() {
        return brand;
    }

    //метод для модификации марки автомобиля
    public void setBrand(String brand) {
        this.brand = brand;
    }

    //Конструктор
    public Auto(String brand, int size) {
        this.brand = brand;
        models = new Model[size];
        for (int i = 0; i < size; i++) {
            models[i] = new Model(DEFAULT_NAME+i, DEFAULT_PRICE);
        }
    }

    @Override
    public Iterator<Model> iterator() {
        return new AutoIterator(this.models);
    }

    //внутренний класс Модель
    public static class Model implements Cloneable,Serializable{
        private String name = null;
        private double price = Double.NaN;

        private Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public Model clone() {
            try {
                return (Model) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        @Override
        public String toString() {
            return "Model{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
    //Класс итератора
    private static class AutoIterator implements Iterator<Model>{
        private Model[] models;
        private int counter = 0;

        public AutoIterator(Model[] models) {
            this.models = models;
        }

        @Override
        public boolean hasNext() {
            return counter < models.length;
        }

        @Override
        public Model next() {
            return models[counter++];
        }
    }

    public static class Memento{
        private byte[] save;

        private Memento(){}
        private void setAuto(Auto auto){
            try(var baos = new ByteArrayOutputStream();var oos = new ObjectOutputStream(baos)) {
                oos.writeObject(auto);
                save = baos.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private Auto getAuto(){
           try(var ois = new ObjectInputStream(new ByteArrayInputStream(save))) {
               return (Auto) ois.readObject();
           } catch (IOException | ClassNotFoundException e) {
               throw new RuntimeException(e);
           }
        }

    }

    //метод для модификации значения названия модели
    public void changeName(String name, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        if (getModelIndexByName(newName) < 0) {
            getModelByName(name).name = newName;
        }
        else {
            throw new DuplicateModelNameException(newName);
        }
    }

    //метод, возвращающий массив названий всех моделей
    public String[] getModelNames() {
        String[] names = new String[models.length];
        for (int i = 0; i < models.length; i++) {
            names[i] = models[i].name;
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
        double[] prices = new double[models.length];
        for (int i = 0; i < models.length; i++) {
            prices[i] = models[i].price;
        }
        return prices;
    }

    //метод добавления названия модели и её цены
    public void addModel(String name, double price) throws DuplicateModelNameException {
        if (price < 0) throw new ModelPriceOutOfBoundsException(price);
        if (getModelIndexByName(name) < 0) {
            models = Arrays.copyOf(models, models.length + 1);
            models[models.length - 1] = new Model(name, price);
            //models= new_models;
        } else {
            throw new DuplicateModelNameException(name);
        }
    }

    //метод удаления модели с заданным именем и её цены
    public void deleteModel(String name, double price) throws NoSuchModelNameException {
        if (price < 0) throw new ModelPriceOutOfBoundsException(price);
        int pos = getModelIndexByName(name);

        if (pos < 0) throw new NoSuchModelNameException(name);
        var newModels = new Model[models.length - 1];

        if (pos != 0)
            System.arraycopy(models, 0, newModels, 0, pos);
        System.arraycopy(models, pos + 1, newModels, pos, models.length - (pos + 1));
        models = newModels;
    }

    public int getModelsSize() {
        return models.length;
    }

    private Model getModelByName(String name) throws NoSuchModelNameException {
        var model = Arrays.stream(models).filter(item -> item.name.equals(name)).findFirst();

        if (model.isEmpty())
            throw new NoSuchModelNameException(name);

        return model.get();
    }

    private int getModelIndexByName(String name) {
        int i = 0;
        while (i < models.length && !models[i].name.equals(name)) {
            i++;
        }
        if (i < models.length)
            return i;
        else
            return -1;
    }

    @Override
    public synchronized Auto clone(){
        try {
            var clone = (Auto) super.clone();
            clone.models = Arrays.stream(models).map(Model::clone).toArray(Model[]::new);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void print(Writer writer){
        if(command != null)
            command.print(writer,this);
    }

    public Memento createMemento(){
        Memento memento = new Memento();
        memento.setAuto(this);
        return memento;
    }

    public void restoreFromMemento(Memento memento){
         Auto old = memento.getAuto();
         this.models = old.models;
         this.command = old.command;
         this.brand = old.brand;
    }

}
