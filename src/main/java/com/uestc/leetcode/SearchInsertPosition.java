package com.uestc.leetcode;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
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
}
