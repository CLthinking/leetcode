package com.uestc.designpattern.eventbus;

import java.lang.reflect.Method;

/**
 * @author CLthinking
 * @date 2019/7/11 下午 10:17
 */
public interface EventContext {

    String getSource();

    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();
}
