package com.uestc.leetcode;

/**
 * @author CLthinking
 * @date 2019/7/12 下午 07:26
 */
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        if (coins == null ||  amount < 0) return 0;
        return help(amount, 0, coins);
    }
    private int help(int amount, int cur, int[] coins) {
        int res = 0;
        if (cur == coins.length) {
            res = amount == 0 ? 1 : 0;
        } else {
            for (int i = 0; i * coins[cur] <= amount; i++) {
                res += help(amount - i * coins[cur], cur + 1, coins);
            }
        }
        return res;
    }

    public int change1(int amount, int[] coins) {
        if (coins == null || amount < 0) return 0;
        int[][] map = new int[coins.length + 1][amount + 1];
        return help1(amount, 0, coins, map);
    }

    private int help1(int amount, int cur, int[] coins, int[][] map) {
        int res = 0;
        if (cur == coins.length) {
            res = amount == 0 ? 1 : 0;
        } else {
            for (int i = 0; i * coins[cur] <= amount ; i++) {
                int mapVal = map[cur + 1][amount - i * coins[cur]];
                if (mapVal != 0) {
                    res += mapVal == -1 ? 0 : mapVal;
                } else {
                    res += help1(amount - i * coins[cur], cur + 1, coins, map);
                }
            }
        }
        map[cur][amount] = res == 0 ? -1 : res;
        return res;
    }
}
