package com.uestc.designpattern.event_driven_framework.framework;

public interface Handler<E extends Event> {

    void onEvent(E e);
}
