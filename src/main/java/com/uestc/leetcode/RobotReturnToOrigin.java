package com.uestc.leetcode;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int horizontal = 0;
        int vertical = 0;
        char[] chars = moves.toCharArray();
        for (char c : chars) {
            if (c == 'U') vertical++;
            else if (c == 'D') vertical--;
            else if (c == 'L') horizontal++;
            else if (c == 'R') horizontal--;
        }
        return horizontal == 0 && vertical == 0;
    }
}
