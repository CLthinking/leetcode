package com.uestc.leetcode;

/**
 * @author CLthinking
 * @date 2019/7/14 上午 11:23
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 1;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row--][col--];
        dp[row][col] = dungeon[row][col] >= 0 ? 1 : -dungeon[row][col] + 1;
        for (int i = col - 1; i >= 0 ; i--) {
            dp[row][i] = Math.max(1, dp[row][i + 1] - dungeon[row][i]);
        }
        int right = 0;
        int down = 0;
        for (int i = row - 1; i >= 0 ; i--) {
            dp[i][col] = Math.max(1, dp[i + 1][col] - dp[i][col]);
        }
        return 0;
    }
}
