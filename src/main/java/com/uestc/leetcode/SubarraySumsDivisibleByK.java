package com.uestc.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
    //Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
    //LeetCode--974. Subarray Sums Divisible by K https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
    // 返回连续非空子数组可以被K整除的个数（sum(i...j)/K = 0）,这题与：LeetCode--523. Continuous Subarray Sum 类似
    // 本质上就是找到连续子数组的和 sum(i...j) = N * K
    public static int subarraysDivByK(int[] A, int K) {
        if (A == null || A.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int res = 0;
        for (int num : A) {
            sum += num;
            sum %= K; // K不可能为0
            if (sum < 0) sum += K;
            res += map.getOrDefault(sum,0);
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(nums, 5));
    }
}
