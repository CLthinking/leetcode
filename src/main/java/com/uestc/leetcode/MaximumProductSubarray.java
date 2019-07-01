package com.uestc.leetcode;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);
            res = Math.max(res, imax);
        }
        return imax;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        maxProduct(nums);
    }
}
