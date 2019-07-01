package com.uestc.designpattern.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    /**
     * 根据真实对象realObject和实现了代理逻辑的dynamicProxy类，创建一个动态代理类。
     * realObject 必须实现一个接口，且只能代理接口中的方法
     * dynamicProxy 必须实现InvocationHandler接口，提供代理逻辑，且必须提供一个参数为Object的public构造方法。
     * @param realObject  需要被代理的真实对象
     * @param dynamicProxy  实现了代理逻辑的类，实现了InvocationHandler接口
     * @return 动态代理类
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T getProxy(Object realObject, Class<? extends InvocationHandler> dynamicProxy)
            throws Exception{
        Constructor<?> constructor= dynamicProxy.getConstructor(Object.class);
        if (constructor == null) {
            throw new RuntimeException("参数dynamicProxy必须有一个Object类型的构造方法");
        }
        return (T)Proxy.newProxyInstance(realObject.getClass().getClassLoader(),
                realObject.getClass().getInterfaces(),
                dynamicProxy.getConstructor(Object.class).newInstance(realObject));
    }
}
