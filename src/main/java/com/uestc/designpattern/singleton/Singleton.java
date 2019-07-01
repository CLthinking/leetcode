package com.uestc.designpattern.singleton;

public class Singleton {

    private static final Singleton singleton = new Singleton();

    private Singleton() {}

    public Singleton getInstance() {
        return singleton;
    }
}
