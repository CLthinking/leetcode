package com.uestc.designpattern.creational.simplefactory;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 09:00
 */
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Java课程视频");
    }
}
