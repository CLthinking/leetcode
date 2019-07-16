package com.uestc.designpattern.creational.singlton;

import java.io.Serializable;

/**
 * @author CLthinking
 * @date 2019/7/16 下午 03:00
 */
public class HungrySingleton implements Serializable {

    private final static HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    private HungrySingleton() {
        if (hungrySingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用!");
        }
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    private Object readResolve() {  // 防止序列化与反序列化破坏单例模式
        return hungrySingleton;
    }
}
