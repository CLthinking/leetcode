package com.uestc.designpattern.creational.singlton;

/**
 * @author CLthinking
 * @date 2019/7/16 上午 11:07
 */
public class T implements Runnable{
    @Override
    public void run() {
//        LazyDoubleCheckSingleton lazyDoubleCheckSingletonSingleton = LazyDoubleCheckSingleton.getInstance();
        ThreadLocalInstance instance = ThreadLocalInstance.getInstance();
        System.out.println(Thread.currentThread().getName() +" " + instance);

    }
}
