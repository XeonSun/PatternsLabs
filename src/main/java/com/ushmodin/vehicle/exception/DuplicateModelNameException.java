package com.ushmodin.vehicle.exception;

public class DuplicateModelNameException extends Exception{
    public String modelName;

    public DuplicateModelNameException(String name){
        super("Модель с именем \"" + name + "\" уже существует");
        modelName = name;
    }
}
