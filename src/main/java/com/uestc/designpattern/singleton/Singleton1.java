package com.uestc.designpattern.singleton;

public class Singleton1 {
    private Singleton1() {}

    private static class SingletonHolder {
        private static final Singleton1 singleton1 = new Singleton1();
    }
    public static Singleton1 getInstance() {
        return SingletonHolder.singleton1;
    }
}
