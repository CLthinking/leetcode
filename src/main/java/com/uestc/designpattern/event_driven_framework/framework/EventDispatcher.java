package com.uestc.designpattern.event_driven_framework.framework;

import java.util.HashMap;
import java.util.Map;

public class EventDispatcher {
    private Map<Class<? extends Event>, Handler<? extends Event>> handles;

    public EventDispatcher() {
        this.handles = new HashMap<>();
    }

    public <E extends Event> void registerHandler(Class<E> event, Handler<E> handler) {
        handles.put(event, handler);
    }

    @SuppressWarnings("unchecked")
    public <E extends Event> void dispatch(E event) {
        Handler<E> handler = (Handler<E>) handles.get(event.getType());
        if (handler != null) {
            handler.onEvent(event);
        }
    }


}
