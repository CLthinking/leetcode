package com.uestc.designpattern.event_driven_framework.handler;

import com.uestc.designpattern.event_driven_framework.event.UserUpdateEvent;
import com.uestc.designpattern.event_driven_framework.framework.Handler;

public class UserUpdateEventHandler implements Handler<UserUpdateEvent> {
    @Override
    public void onEvent(UserUpdateEvent userUpdateEvent) {
        System.out.println(userUpdateEvent.getUser().getName() + " update!");
    }
}
