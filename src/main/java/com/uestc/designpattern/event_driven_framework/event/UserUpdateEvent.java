package com.uestc.designpattern.event_driven_framework.event;

import com.uestc.designpattern.event_driven_framework.model.User;

public class UserUpdateEvent extends AbstractEvent {

    private User user;

    public UserUpdateEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
