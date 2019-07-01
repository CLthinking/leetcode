package com.uestc.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object realObject;

    public DynamicProxy(Object o) {
        realObject = o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("entering " + method.getName());
        Object result = method.invoke(realObject, args);
        System.out.println("leaving " + method.getName());
        return result;
    }

}
