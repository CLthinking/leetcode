package com.uestc.designpattern.principle.demeter;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 08:47
 */
public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();

        boss.commandCheckNumber(teamLeader);
    }
}
