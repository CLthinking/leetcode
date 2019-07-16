package com.uestc.designpattern.creational.builder;

/**
 * @author CLthinking
 * @date 2019/7/16 上午 10:15
 */
public class Coach {

    private CourseBuilder courseBuilder;

    public void setCourseBuilder(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }

    public Course makeCourse(String courseName, String coursePPT, String courseVideo,
                             String courseArticle, String courseQA) {
        courseBuilder.buildCourseName(courseName);
        courseBuilder.buildCoursePPT(coursePPT);
        courseBuilder.buildCourseVideo(courseVideo);
        courseBuilder.buildCourseArticle(courseArticle);
        courseBuilder.buildCourseQA(courseQA);

        return courseBuilder.makeCourse();
    }
}
