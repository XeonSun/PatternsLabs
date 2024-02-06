package com.ushmodin.patterns.singleton;

public class Main {
    public static void main(String[] args) {
        var props = Props.getInstance();
        System.out.println(props.toString());
    }
}