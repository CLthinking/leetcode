package com.uestc.leetcode;

import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int lo = 0;
        int hi = 0;
        while (hi < nums.length) {
            if (nums[hi] == val) {
                hi++;
            } else {
                nums[lo++] = nums[hi++];
            }
        }
        return lo;
    }
}
