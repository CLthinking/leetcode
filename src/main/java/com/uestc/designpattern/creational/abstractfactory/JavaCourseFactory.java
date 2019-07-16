package com.uestc.designpattern.creational.abstractfactory;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 10:32
 */
public class JavaCourseFactory implements CourseFactory{
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getAticle() {
        return new JavaArticle();
    }
}
