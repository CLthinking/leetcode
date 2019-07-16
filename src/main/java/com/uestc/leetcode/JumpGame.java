package com.uestc.leetcode;

/**
 * @author CLthinking
 * @date 2019/7/11 下午 04:05
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException();
        int canMaxStep = 0;
        for (int i = 0; i < nums.length; i++) {
            if (canMaxStep < i) return false;
            canMaxStep = Math.max(canMaxStep, i + nums[i]);
        }
        return true;
    }

}
