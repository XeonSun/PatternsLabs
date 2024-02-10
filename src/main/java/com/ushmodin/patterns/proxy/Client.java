package com.ushmodin.patterns.proxy;

//Не самый удачный пример на мой взгляд так как proxy класс не реализует интерфейс такой же как и у реального объекта
public class Client {
    public static void main(String args[]){
        double a = 10.1;
        double b = Double.NaN;

        Multipiler multipiler = new ProxyMultiplier();
        System.out.println(multipiler.mult(a,b));
    }
}
