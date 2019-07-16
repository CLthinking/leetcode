package com.uestc.duxiaoman;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author CLthinking
 * @date 2019/7/16 下午 12:28
 */
public class Main {
    /**
     * 在Z省，有若干个个城市坐落在一条直线上，从左到右依次标号1,2,3,…，其中每个城市有一个火车站点，
     * 现今已经开放了n条火车路线，第i条火车路线是从第Yi个城市到第Xi个城市，因为Z省地势奇特，
     * 标号小的城市地势较低，所以火车是从高往低开的，再通过神秘力量传送回高地，即Yi一定大于Xi，
     * 它在沿途的所有城市都会停靠（显然不包括起点Yi，但是包括终点Xi），火车停靠就需要火车站台来运营维护。
     * 火车站台随着运营线路的数量不同，其损耗速度、维护成本也各异，现在我们想知道所有站台中，
     * 所运营的线路数最大是多少。
     *
     * 输入描述:
     * 第一行一个数n。（1≤n≤100000）
     *
     * 接下来n行每行两个数Xi和Yi，分别代表第i条火车路线的终点和起点。（1≤Xi<Yi≤1e5）
     *
     * 输出描述:
     * 共一行，一个非负整数，表示最大运营路线数。
     *
     * 输入例子1:
     * 4
     * 4 7
     * 2 6
     * 2 5
     * 1 2
     *
     * 输出例子1:
     * 3
     */
    private static int maxServiceRailwayStation(int[][] mtx) {
        int n = mtx.length;
        int[] nums = new int[100000 + 2];
        for (int[] station : mtx) {
            nums[station[0] + 1]++;
            nums[station[1] + 1]--;
        }
        int[] num = new int[1];
        return Arrays.stream(nums).map(i -> { num[0] += i;return num[0]; }).max().getAsInt();
//        int res = 0;
//        int ans = 0;
//        int start = -1;
//        int end = -1;
//        for (int i = 0; i < nums.length; ++i) {
//            ans += nums[i];
//            int prev = res;
//            res = Math.max(res, ans);
//            if (res == ans) {
//                start = i;
//            }
//            if (prev != res) {
//                end = i;
//            }
//        }
//        System.out.println("start: " + start + " end: " + end);
//        return res;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] mtx = new int[n][2];
        for (int i = 0; i < n; i++) {
            mtx[i][0] = cin.nextInt();
            mtx[i][1] = cin.nextInt();
        }
        System.out.println(maxServiceRailwayStation(mtx));
    }
}
