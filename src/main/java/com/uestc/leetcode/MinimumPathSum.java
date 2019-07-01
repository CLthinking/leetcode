package com.uestc.leetcode;

public class MinimumPathSum {
    // 时间复杂度O(M * N), 空间复杂度O(M * N)
    public int minPathSum0(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        // 初始化
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 正式开始 dp
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[row - 1][col - 1];
    }

    // 时间复杂度O(M * N), 空间复杂度O(min(M, N))
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int less = Math.min(grid.length, grid[0].length);
        int more = Math.max(grid.length, grid[0].length);
        boolean rowMore = more == grid.length;
        int[] arr = new int[less];
        // 初始化
        arr[0] = grid[0][0];
        for (int i = 1; i < less; i++) {
            arr[i] = arr[i - 1] + (rowMore ? grid[0][i] : grid[i][0]);
        }

        // 开始dp
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowMore ? grid[i][0] : grid[0][i]);
            for (int j = 1; j < less; j++) {
                arr[j] = Math.min(arr[j - 1], arr[j]) + (rowMore ? grid[i][j] : grid[j][i]);
            }
        }
        return arr[less - 1];
    }
}
