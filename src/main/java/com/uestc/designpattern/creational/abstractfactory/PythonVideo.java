package com.uestc.designpattern.creational.abstractfactory;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 10:34
 */
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Python视频课程");
    }
}
