package com.uestc.designpattern.creational.builder.v2;

/**
 * @author CLthinking
 * @date 2019/7/16 上午 10:38
 */
public class Test {
    public static void main(String[] args) {
        Course course = new Course.CourseBuilder().buildCourseName("java 课程")
                .buildCoursePPT("java ppt").buildCourseVideo("java video").build();
        System.out.println(course);
    }
}
