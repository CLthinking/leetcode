package com.uestc.designpattern.creational.simplefactory;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 09:01
 */
public class Test {
    public static void main(String[] args) {
//        Video video = new JavaVideo();
//        video.produce();

        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(JavaVideo.class);
        if (video == null) {
            return;
        }
        video.produce();
    }
}
