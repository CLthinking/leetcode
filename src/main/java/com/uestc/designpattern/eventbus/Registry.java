package com.uestc.designpattern.eventbus;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author CLthinking
 * @date 2019/7/11 下午 10:09
 */
class Registry {

    /**
     * 注册表，维持topic和对应Subscriber之间的关系
     */
    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<Subscriber>> subscriberContainer
            = new ConcurrentHashMap<>();

    /**
     * 将subscriber中所有通过@Subscribe注解标记的方法注册到注册表中
     * @param subscriber
     */
    public void bind(Object subscriber) {
        getSubscribeMethods(subscriber).forEach(m -> registerMethod(subscriber, m));
    }

    /**
     * 快速解绑定
     * @param subscriber
     */
    public void unbind(Object subscriber) {
        subscriberContainer.forEach((key, queue) -> {
            queue.forEach(s -> {
                if (s.getSubscriberObject() == subscriber) {
                    s.setDisable(true);
                }
            });
        });
    }

    /**
     * 获取一个topic对应的所有注册方法
     * @param topic
     * @return
     */
    public ConcurrentLinkedQueue<Subscriber> scanSubscriber(String topic) {
        return subscriberContainer.get(topic);
    }

    /**
     * 得到所有使用@Subscribe注解标记的方法，且声明为public,参数只有一个
     * @param subscriber
     * @return
     */
    private List<Method> getSubscribeMethods(Object subscriber) {
        List<Method> list = new ArrayList<>();
        Class<?> cls = subscriber.getClass();
        while (null != cls) {
            Method[] methods = cls.getDeclaredMethods();
            Arrays.stream(methods)
                    .filter(m -> m.isAnnotationPresent(Subscribe.class)
                            && m.getParameterCount() == 1
                            && m.getModifiers() == Modifier.PUBLIC)
                    .forEach(list::add);
            cls = cls.getSuperclass();
        }
        return list;
    }

    /**
     * 注册一个方法
     * @param subscriber
     * @param method
     */
    private void registerMethod(Object subscriber, Method method) {
        Subscribe subscribe = method.getDeclaredAnnotation(Subscribe.class);
        String topic = subscribe.topic();
        subscriberContainer.putIfAbsent(topic, new ConcurrentLinkedQueue<>());
        subscriberContainer.get(topic).add(new Subscriber(subscriber, method));
    }

}
