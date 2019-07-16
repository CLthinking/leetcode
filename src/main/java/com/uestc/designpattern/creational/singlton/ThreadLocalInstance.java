package com.uestc.designpattern.creational.singlton;

/**
 * @author CLthinking
 * @date 2019/7/16 下午 04:42
 */
public class ThreadLocalInstance {

    private static final ThreadLocal<ThreadLocalInstance> threadLocalInstance =
            ThreadLocal.withInitial(ThreadLocalInstance::new);

    private ThreadLocalInstance() {}

    public static ThreadLocalInstance getInstance() {
        return threadLocalInstance.get();
    }
}
