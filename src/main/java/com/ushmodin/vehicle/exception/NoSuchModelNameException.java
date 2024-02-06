package com.ushmodin.vehicle.exception;

public class NoSuchModelNameException extends Exception{
    public String modelName;

    public NoSuchModelNameException(String name){
        super("Модель с именем \"" + name + "\" не найдена");
        modelName = name;
    }
}
