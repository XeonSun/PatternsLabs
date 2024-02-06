package com.ushmodin.vehicle;

import com.ushmodin.vehicle.exception.DuplicateModelNameException;
import com.ushmodin.vehicle.exception.NoSuchModelNameException;

public interface Transport extends Cloneable {
    //метод для получения марки мотоцикла
    String getBrand();

    //метод для модификации марки мотоцикла
    void setBrand(String brand);

    //метод для модификации значения названия модел
    void changeName(String name, String newName) throws NoSuchModelNameException, DuplicateModelNameException;

    //метод, возвращающий массив названий всех моделей
    String[] getModelNames();

    //метод для получения значения цены модели по её названию,
    double getModelPrice(String name) throws NoSuchModelNameException;

    //метод для модификации значения цены модели по её названию
    void setModelPrice(String name, double newPrice) throws NoSuchModelNameException;

    //метод, возвращающий массив значений цен моделей
    double[] getModelPrices();

    //метод добавления названия модели и её цены
    void addModel(String name, double price) throws DuplicateModelNameException;

    //метод удаления модели с заданным именем и её цены
    void deleteModel(String name, double price) throws NoSuchModelNameException;

    int getModelsSize();

    Transport clone();
}
