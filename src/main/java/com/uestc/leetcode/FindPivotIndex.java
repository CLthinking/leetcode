package com.uestc.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - 2 * leftSum == nums[i]) {
                return i;
            }
            leftSum += nums[i];

            /* version 1
            leftSum += i == 0 ? 0 : nums[i - 1];
            int s = sum - nums[i];
            if ((s & 1) == 0 && leftSum == s >> 1) {
                return i;
            }
            */
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(-5 >> 1);
    }
}
