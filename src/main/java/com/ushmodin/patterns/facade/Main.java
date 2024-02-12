package com.ushmodin.patterns.facade;

import com.ushmodin.patterns.facade.traffic.TrafficSimulator;

import java.io.IOException;

//Тут бы неплохо использовать Абстрактную фабрику
public class Main {
    public static void main(String[] args){
            TrafficSimulator t = new TrafficSimulator();
    }
}
