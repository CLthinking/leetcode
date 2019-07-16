package com.uestc.designpattern.eventbus;

/**
 * @author CLthinking
 * @date 2019/7/11 下午 10:19
 */
public interface EventExceptionHandler {
    void handle(Throwable cause, EventContext context);
}
