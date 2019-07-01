package com.uestc.designpattern.event_driven_framework.event;

import com.uestc.designpattern.event_driven_framework.framework.Event;

public class AbstractEvent implements Event {
    @Override
    public Class<? extends Event> getType() {
        return getClass();
    }
}
