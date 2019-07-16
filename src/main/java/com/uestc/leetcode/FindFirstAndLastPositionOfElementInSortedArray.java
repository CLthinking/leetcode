package com.uestc.leetcode;

/**
 * @author CLthinking
 * @date 2019/7/9 下午 07:12
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        if (nums[hi] != target) return res;
        else res[0] = lo;

        hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2 + 1;
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid;
        }
        res[1] = hi;

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,5,6,7,8,9,10};
        searchRange(nums, 5);
    }
}
