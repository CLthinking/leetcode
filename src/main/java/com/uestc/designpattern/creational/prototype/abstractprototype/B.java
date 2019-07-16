package com.uestc.designpattern.creational.prototype.abstractprototype;

/**
 * @author CLthinking
 * @date 2019/7/16 下午 05:22
 */
public class B extends A {
    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B();
        b.clone();
    }
}
