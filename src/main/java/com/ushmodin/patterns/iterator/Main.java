package com.ushmodin.patterns.iterator;

import com.ushmodin.vehicle.Auto;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args){
        Auto a = new Auto("test",10);

        var i = a.iterator();
        while (i.hasNext())
            System.out.println(i.next());

        for (Auto.Model m:a) {
            System.out.println(m);
        }

        System.out.println("Stream API <3 !");
        StreamSupport.stream(a.spliterator(),false).forEach(System.out::println);
    }
}
