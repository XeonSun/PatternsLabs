package com.ushmodin.patterns.proxy;

//Не самый удачный пример в задании на мой взгляд. так как proxy класс не реализует интерфейс такой же как и у реального объекта,
//Больше похоже на адаптер?
public class Client {
    public static void main(String args[]){
        double a = 10.1;
        double b = 10;

        Multipiler multipiler = new ProxyMultiplier();
        System.out.println(multipiler.mult(a,b));
        System.out.println("finish");
    }
}
