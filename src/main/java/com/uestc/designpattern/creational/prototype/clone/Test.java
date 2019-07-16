package com.uestc.designpattern.creational.prototype.clone;

import java.util.Date;

/**
 * @author CLthinking
 * @date 2019/7/16 下午 05:25
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date birthday = new Date(0L);
        Pig pig1 = new Pig("佩奇", birthday);
        Pig pig2 = (Pig) pig1.clone();

        System.out.println(pig1);
        System.out.println(pig2);

        pig1.getBirthday().setTime(66666666666666L);

        System.out.println(pig1);
        System.out.println(pig2);
    }
}
