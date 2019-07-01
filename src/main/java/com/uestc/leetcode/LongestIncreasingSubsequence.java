package com.uestc.leetcode;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int prev = nums[i];
            int tmp = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > prev) {
                    tmp++;
                    prev = nums[j];
                }
            }
            res = Math.max(res, tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,4};
        System.out.println(lengthOfLIS(nums));
    }
}
