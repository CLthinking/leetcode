package com.uestc.designpattern.principle.singleresponsibility;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 08:15
 */
public class Bird {

    public void mainMoveMode(String birdName) {
        if ("鸵鸟".equals(birdName)) {
            System.out.println(birdName + "用脚走");
        }
        System.out.println(birdName + "用翅膀飞");
    }
}
