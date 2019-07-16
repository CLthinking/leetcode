package com.uestc.leetcode;

/**
 * @author CLthinking
 * @date 2019/7/11 下午 04:36
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0;
        int next = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur < i) {
                res++;
                cur = next;
            }
            next = Math.max(next, i + nums[i]);
        }
//        Integer.class.isAssignableFrom()
        return res;
    }
}
