package com.uestc.designpattern.event_driven_framework;

import com.uestc.designpattern.event_driven_framework.event.UserCreatEvent;
import com.uestc.designpattern.event_driven_framework.event.UserUpdateEvent;
import com.uestc.designpattern.event_driven_framework.framework.EventDispatcher;
import com.uestc.designpattern.event_driven_framework.handler.UserCreatEventHandler;
import com.uestc.designpattern.event_driven_framework.handler.UserUpdateEventHandler;
import com.uestc.designpattern.event_driven_framework.model.User;

public class Main {
    public static void main(String[] args) {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerHandler(UserCreatEvent.class, new UserCreatEventHandler());
        dispatcher.registerHandler(UserUpdateEvent.class, new UserUpdateEventHandler());

        dispatcher.dispatch(new UserCreatEvent(new User("CLthinking")));
        dispatcher.dispatch(new UserUpdateEvent(new User("CL")));
        Runtime runtime = Runtime.getRuntime();
    }
}
