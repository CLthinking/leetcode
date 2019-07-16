package com.uestc.designpattern.creational.factorymethod;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 09:50
 */
public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
