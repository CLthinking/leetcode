package com.uestc.leetcode;

/**
 * @author CLthinking
 * @date 2019/7/11 下午 03:14
 */
public class CoinChange {
    // 完全背包问题
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        // dp[i][j] 表示使用coins[0...i]兑换j的最小货币数，如果无法兑换里面保存的是Integer.MAX_VALUE
        // dp[i][j] = min{dp[i-1][j], dp[i][j - arr[i] + 1}
        int[][] dp = new int[coins.length][amount + 1];
        int max = Integer.MAX_VALUE;
        // 初始化工作
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = max;
            if (i >= coins[0] && dp[0][i - coins[0]] != max) {
                dp[0][i] = dp[0][i - coins[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                left = max;
                if (j - coins[i] >= 0 && dp[i][j - coins[i]] != max) {
                    left = dp[i][j - coins[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[coins.length - 1][amount] != max ? dp[coins.length - 1][amount] : -1;
    }


    /**
     * 压缩空间的解法
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = max;
            if (i >= coins[0] && dp[i - coins[0]] != max) {
                dp[i] = dp[i - coins[0]] + 1;
            }
        }

        int left = 0;
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                left = max;
                if (j >= coins[i] && dp[j - coins[i]] != max) {
                    left = dp[j - coins[i]] + 1;
                }
                dp[j] = Math.min(left, dp[j]);
            }
        }
        return dp[amount] != max ? dp[amount] : -1;

    }

}
