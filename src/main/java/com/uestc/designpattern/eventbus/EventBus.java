package com.uestc.designpattern.eventbus;

import java.util.concurrent.Executor;

/**
 * @author CLthinking
 * @date 2019/7/11 下午 10:05
 */
public class EventBus implements Bus {

    private final Registry registry = new Registry();

    private String busName;

    private final static String DEFAULT_NAME = "default";

    private final static String DEFAULT_TOPIC = "default-topic";

    private final Dispatcher dispatcher;

    public EventBus() {
        this(DEFAULT_NAME, Dispatcher.SEQ_EXECUTOR, null);
    }

    public EventBus(String busName) {
        this(busName, Dispatcher.SEQ_EXECUTOR, null);
    }

    public EventBus(EventExceptionHandler handler) {
        this(DEFAULT_NAME, Dispatcher.SEQ_EXECUTOR, handler);
    }


    EventBus(String busName, Executor executor, EventExceptionHandler handler) {
        this.busName = busName;
        this.dispatcher = Dispatcher.newDispatcher(executor, handler);
    }

    @Override
    public void register(Object subscriber) {
        this.registry.bind(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        this.registry.unbind(subscriber);
    }

    @Override
    public void post(Object event) {
        this.post(event, DEFAULT_TOPIC);
    }

    @Override
    public void post(Object event, String topic) {
        this.dispatcher.dispatch(this, registry, event, topic);
    }

    @Override
    public void close() {
        this.dispatcher.close();
    }

    @Override
    public String getBusName() {
        return this.busName;
    }
}
