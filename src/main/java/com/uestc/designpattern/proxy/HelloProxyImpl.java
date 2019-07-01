package com.uestc.designpattern.proxy;

public class HelloProxyImpl implements HelloProxy {
    @Override
    public void proxy1(String str) {
        System.out.println("Hello ! " + str);
    }

    @Override
    public void proxy2() {
        System.out.println("HELLO!!!");
    }
}
