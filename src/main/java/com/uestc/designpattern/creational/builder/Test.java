package com.uestc.designpattern.creational.builder;

/**
 * @author CLthinking
 * @date 2019/7/16 上午 10:21
 */
public class Test {
    public static void main(String[] args) {
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);

        Course course = coach.makeCourse("java", "java ppt", "java video",
                "java article", "java qa");
        System.out.println(course);
    }
}
