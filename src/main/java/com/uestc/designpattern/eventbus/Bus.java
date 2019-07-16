package com.uestc.designpattern.eventbus;

/**
 * @author CLthinking
 * @date 2019/7/11 下午 09:59
 */
public interface Bus {
    /**
     * 将某个对象注册到bus上
     * @param subscriber
     */
    void register(Object subscriber);


    /**
     * 将某个对象取消注册
     * @param subscriber
     */
    void unregister(Object subscriber);

    /**
     * 发布事件到默认的topic上
     * @param event
     */
    void post(Object event);

    /**
     * 发布事件到指定的topic上
     * @param event
     * @param topic
     */
    void post(Object event, String topic);

    /**
     * 关闭该bus
     */
    void close();


    /**
     * 获取到该bus的名字
     * @return
     */
    String getBusName();

}
