package com.uestc.leetcode;

import java.util.Arrays;

public class SearchInsertPosition {

    public int searchInsert0(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target > nums[mid]) {
                lo = mid + 1;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int midNum = nums[mid];
            if (target > midNum) {
                lo = mid + 1;
            } else if (target < midNum) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public int searchInsert1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int res = Arrays.binarySearch(nums, target);
        return res >= 0 ? res : -res - 1;
    }

}
