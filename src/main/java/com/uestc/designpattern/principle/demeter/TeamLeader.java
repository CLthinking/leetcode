package com.uestc.designpattern.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 08:43
 */
public class TeamLeader {

    public void checkNumberOfCourses() {
        List<Course> courseList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        System.out.println("在线的课程数量是：" + courseList.size());
    }
}
