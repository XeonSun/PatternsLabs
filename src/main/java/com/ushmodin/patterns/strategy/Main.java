package com.ushmodin.patterns.strategy;

import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        if(args.length < 1)
            throw new RuntimeException("Invalid command line args");

        String filename = args[0];

        int n = 100000000;
        int[] arrout = new Random().ints(n,0,11).toArray();

        try(var oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(arrout);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }



        try(var ois = new ObjectInputStream(new FileInputStream(filename))){
            int[] arr =(int[]) ois.readObject();

            long start1 = System.currentTimeMillis();
            Context context = new Context(new DefaultCountStrategy());
            var res1  = context.countDuplicates(arr);
            long end1 = System.currentTimeMillis();

            System.out.println(res1.toString() +" Time " + (end1-start1));

            context.setCountStrategy(new NewCountStrategy());
            long start2 = System.currentTimeMillis();
            var res2 = context.countDuplicates(arr);
            long end2 = System.currentTimeMillis();

            System.out.println(res2.toString() +" Time " + (end2-start2));

            context.setCountStrategy(new CollectorsStrategy());
            long start3 = System.currentTimeMillis();
            var res3 = context.countDuplicates(arr);
            long end3 = System.currentTimeMillis();

            System.out.println(res3.toString() +" Time " + (end3-start3));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
