package com.uestc.designpattern.eventbus;

import java.lang.reflect.Method;

/**
 * @author CLthinking
 * @date 2019/7/11 下午 10:10
 */

/**
 * 一个Subscriber封装了一个对象和一个方法，一个对象中可能有多个使用@Subscribe注解标记的方法
 */
public class Subscriber {
    private final Object subscriberObject;
    private final Method subscriberMethod;

    private boolean disable = false;

    public Subscriber(Object subscriberObject, Method subscriberMethod) {
        this.subscriberObject = subscriberObject;
        this.subscriberMethod = subscriberMethod;
    }

    public Object getSubscriberObject() {
        return subscriberObject;
    }

    public Method getSubscriberMethod() {
        return subscriberMethod;
    }

    public boolean isDisable() {
        return disable;
    }

    public boolean isNotDisable() {return !isDisable();}

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public void changeDisable() {
        disable = !disable;
    }

}
