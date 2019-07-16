package com.uestc.designpattern.creational.factorymethod;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 09:00
 */
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Python课程");
    }
}
