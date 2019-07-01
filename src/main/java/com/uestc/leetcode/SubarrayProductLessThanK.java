package com.uestc.leetcode;

public class SubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return 0;
        int left = 0;
        int prod = 1;
        int res = 0;
        for (int right = 0; right < nums.length; ++ right) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            res += right - left + 1;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,8,1,8};
        System.out.println(numSubarrayProductLessThanK(nums, 5));
    }
}
