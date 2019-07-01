package com.uestc.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    /**
     * LeetCode--930. Binary Subarrays With Sum https://leetcode.com/problems/binary-subarrays-with-sum/description/
     * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
     * 1.A.length <= 30000
     * 2.0 <= S <= A.length
     * 3.A[i] is either 0 or 1.
     * @param A
     * @param S
     * @return
     */
    public int numSubarraysWithSum(int[] A, int S) {
        if (A == null || A.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int res = 0;
        for (int num : A) {
            sum += num;
            res += map.getOrDefault(sum - S, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
