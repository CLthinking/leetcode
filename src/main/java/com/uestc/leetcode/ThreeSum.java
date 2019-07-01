package com.uestc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int lo = i + 1, hi = nums.length - 1, num = -nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] > num) {
                    hi--;
                } else if (nums[lo] + nums[hi] < num) {
                    lo++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo + 1] == nums[lo]) lo++;
                    while (lo < hi && nums[hi - 1] == nums[hi]) hi--;
                    lo++; hi--;
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSumCopy(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int lo = i + 1;
            int hi = nums.length - 1;
            int target = -nums[i];
            while (lo < hi) {
                if ((nums[lo] + nums[hi]) > target) {
                    hi--;
                } else if ((nums[lo] + nums[hi]) < target) {
                    lo++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo + 1] == nums[lo]) lo++;
                    while (lo < hi && nums[hi - 1] == nums[hi]) hi--;
                    lo++;
                    hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println(threeSum(nums));
    }
}
