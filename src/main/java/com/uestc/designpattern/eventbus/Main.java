package com.uestc.designpattern.eventbus;

/**
 * @author CLthinking
 * @date 2019/7/12 下午 08:18
 */
public class Main {

    public static void main(String[] args) {
        Bus bus = new EventBus();
        bus.register(new SimpleSubscriber1());
        bus.post("hello");
        bus.post("你好");
        bus.post("welcome", "test");

    }
}
