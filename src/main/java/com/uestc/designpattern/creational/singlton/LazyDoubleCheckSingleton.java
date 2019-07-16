package com.uestc.designpattern.creational.singlton;

/**
 * @author CLthinking
 * @date 2019/7/16 上午 11:26
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton() {}
    public static LazyDoubleCheckSingleton getInstance() {
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazyDoubleCheckSingleton == null) {
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                    //1. 分配内存给这个对象
                    //2. 初始化对象
                    //3. 设置lazyDoubleCheckSingleton
                    /**  线程0                                             线程1
                     * 1. 分配内存给这个对象
                     * 3. 设置lazyDoubleCheckSingleton
                     *                                            判断instance是否为null
                     *                                            线程1初次返回对象（此时对象还没执行初始化操作）
                     * 2. 初始化对象
                     * 4.线程0初次访问对象
                     *
                     * 解决办法：1、禁止重排序； 加volatile
                     *           2、其他线程看不到这个重排序  使用静态内部类
                     */

                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
