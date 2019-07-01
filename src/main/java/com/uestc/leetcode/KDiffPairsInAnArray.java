package com.uestc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
    public static int findPairs0(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) return 0;
        Arrays.sort(nums);
        if (k == 0) {
            return helper(nums);
        }
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (Arrays.binarySearch(nums, k + nums[i]) > i) {
                res++;
            }
        }
        return res;
    }

    private static int helper(int[] nums) {
        int res = 0;
        int i = 0;
        int N = nums.length;
        while (i < N - 1) {
            int exceptI = i;
            while (i < N - 1 && nums[i + 1] == nums[i]) i++;
            if (i != exceptI) res++;
            i++;
        }
        return res;
    }

    public static int findPairs1(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            for (j = Math.max(j, i + 1); j < nums.length && nums[j] - nums[i] < k; ++j) ;
            if (j < nums.length && nums[j] - nums[i] == k) res++;
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) i++;
        }
        return res;
    }

    public static int findPairs2(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0 && entry.getValue() > 1 || k != 0 && map.containsKey(k + entry.getKey())) {
                res++;
            }
        }
        return res;
    }

    public static void main (String[]args){
        int[] nums = {1, 3, 1, 5, 4};
        System.out.println(findPairs2(nums, 0));
    }
}
