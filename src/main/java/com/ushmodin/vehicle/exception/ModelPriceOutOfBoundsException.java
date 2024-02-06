package com.ushmodin.vehicle.exception;

public class ModelPriceOutOfBoundsException extends RuntimeException{
    public Double price;
    public ModelPriceOutOfBoundsException(Double price){
        super("Неверная цена: \"" + price );
        this.price = price;
    }
}
