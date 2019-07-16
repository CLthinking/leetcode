package com.uestc.designpattern.principle.demeter;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 08:43
 */
public class Boss {

    public void commandCheckNumber(TeamLeader teamLeader) {

        teamLeader.checkNumberOfCourses();
    }
}
