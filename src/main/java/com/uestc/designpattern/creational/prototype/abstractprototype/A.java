package com.uestc.designpattern.creational.prototype.abstractprototype;

/**
 * @author CLthinking
 * @date 2019/7/16 下午 05:21
 */
public abstract class A implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
