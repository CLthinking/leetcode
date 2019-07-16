package com.uestc.designpattern.creational.abstractfactory;

/**
 * @author CLthinking
 * @date 2019/7/16 上午 09:42
 */
public class Test {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getAticle();

        video.produce();
        article.produce();
    }
}
