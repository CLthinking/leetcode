package com.uestc.designpattern.creational.factorymethod;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 09:53
 */
public class FEVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制FE视频");
    }
}
