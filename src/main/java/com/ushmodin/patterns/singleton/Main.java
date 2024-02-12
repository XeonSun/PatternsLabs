package com.ushmodin.patterns.singleton;

public class Main {
    public static void main(String[] args) {
        var props = Props.getInstance();
        var props2 = Props.getInstance();
        System.out.println(props.equals(props2));
        System.out.println(props);
    }
}