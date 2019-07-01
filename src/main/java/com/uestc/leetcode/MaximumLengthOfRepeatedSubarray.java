package com.uestc.leetcode;

public class MaximumLengthOfRepeatedSubarray {
    public int findLength0(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return 0;
        int[] hash = new int[100 * 2];
        for (int num : A) {
            hash[2 * num]++;
        }
        for (int num : B) {
            hash[2 * num + 1]++;
        }
        int res = 0;
        for (int i = 0; i < hash.length; i += 2) {
            res += Math.min(hash[i], hash[i + 1]);
        }
        return  res;
    }
    public int findLength(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return 0;
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
