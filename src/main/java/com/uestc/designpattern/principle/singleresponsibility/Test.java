package com.uestc.designpattern.principle.singleresponsibility;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 08:16
 */
public class Test {

    public static void main(String[] args) {
//        Bird bird = new Bird();
//        bird.mainMoveMode("大雁");
//        bird.mainMoveMode("鸵鸟");

        FlyBrid flyBrid = new FlyBrid();
        flyBrid.mainMoveMode("大雁");

        WalkBrid walkBrid = new WalkBrid();
        walkBrid.mainMoveMode("鸵鸟");
    }
}
