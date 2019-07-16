package com.uestc.designpattern.creational.abstractfactory;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 10:32
 */
public class PythonCourseFactory implements CourseFactory{
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getAticle() {
        return new PythonArticle();
    }
}
