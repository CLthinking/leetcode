package com.uestc.designpattern.eventbus;

/**
 * @author CLthinking
 * @date 2019/7/12 下午 08:15
 */
public class SimpleSubscriber1 {

    @Subscribe
    public void method1(String msg) {
        System.out.println("==SimpleSubscriber1== method1==" + msg);
    }

    @Subscribe(topic = "test")
    public void method2(String msg) {
        System.out.println("==SimpleSubscriber1== method2==" + msg);
    }
}
