package com.uestc.designpattern.event_driven_framework.framework;

public interface Event {

    Class<? extends Event> getType();
}
