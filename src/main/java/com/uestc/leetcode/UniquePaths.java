package com.uestc.leetcode;


public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) return 0;
        int N = m + n - 2;
        if (m < n) return uniquePaths(n , m);
        // 数学公式：C N , n;
        long res = 1;
        return 0;

    }
}
