package com.uestc.leetcode;

/**
 * @author CLthinking
 * @date 2019/7/9 下午 07:29
 */
public class BinarySearch {
    public int search0(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return nums[lo] == target ? lo : -1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = hi - (hi - lo) / 2;
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid;
        }
        return nums[hi] == target ? hi : -1;
    }
}
