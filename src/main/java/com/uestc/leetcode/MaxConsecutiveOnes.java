package com.uestc.leetcode;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes0(int[] nums) {
         if (nums == null || nums.length == 0) return 0;
         int start;
         int res = 0;
         for (int i = 0; i < nums.length; i++) {
             if (nums[i] == 1) {
                 start = i;
                 while (i < nums.length && nums[i] == 1)
                     i++;
                 res = Math.max(res, i - start);
             }
         }
         return res;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            res = Math.max(res, count = num == 0 ? 0 : count++ );
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        findMaxConsecutiveOnes0(nums);
    }
}
