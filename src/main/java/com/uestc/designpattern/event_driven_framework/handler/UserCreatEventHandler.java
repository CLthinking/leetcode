package com.uestc.designpattern.event_driven_framework.handler;

import com.uestc.designpattern.event_driven_framework.event.UserCreatEvent;
import com.uestc.designpattern.event_driven_framework.framework.Handler;

public class UserCreatEventHandler implements Handler<UserCreatEvent> {
    @Override
    public void onEvent(UserCreatEvent userCreatEvent) {
        System.out.println(userCreatEvent.getUser().getName() + " creat");
    }
}
