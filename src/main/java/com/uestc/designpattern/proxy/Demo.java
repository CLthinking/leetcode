package com.uestc.designpattern.proxy;

public class Demo {
    public static void main(String[] args) throws Exception{
        HelloProxy proxy =  ProxyUtil.getProxy(new HelloProxyImpl(), DynamicProxy.class);
        proxy.proxy1("CLthinking");
        proxy.proxy2();
    }
}
