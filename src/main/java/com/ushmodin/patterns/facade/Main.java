package com.ushmodin.patterns.facade;

import com.ushmodin.patterns.facade.traffic.TrafficSimulator;

//Тут бы неплохо использовать Абстрактную фабрику
public class Main {
    public static void main(String[] args){
            TrafficSimulator t = new TrafficSimulator();
            t.start();
    }
}
