package com.uestc.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    /**
     * 判断数组中是否存在连续子序列的和 = N*k
     * map里面保存的是 sum(0...i) % k 最早出现的下标
     * 如果 sum(0...i) = sum(0...j) 那么 子序列 (i..j]的和一定可以被k整除
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            Integer prev = map.get(sum);
            if (prev != null) {
                if ( i - prev > 1)  // 这一行不能移到上面去，因为map里面记录的应该是出现最早的位置
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
