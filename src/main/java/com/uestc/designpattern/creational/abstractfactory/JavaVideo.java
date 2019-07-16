package com.uestc.designpattern.creational.abstractfactory;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 10:34
 */
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Java视频课程");
    }
}
