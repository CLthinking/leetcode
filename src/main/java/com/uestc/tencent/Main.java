package com.uestc.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author CLthinking
 * @date 2019/7/14 下午 01:06
 */
public class Main {
    /**
     * 翻转数列
     * 小Q定义了一种数列称为翻转数列:
     * 给定整数n和m, 满足n能被2m整除。对于一串连续递增整数数列1, 2, 3, 4..., 每隔m个符号翻转一次, 最初符号为'-';。
     * 例如n = 8, m = 2, 数列就是: -1, -2, +3, +4, -5, -6, +7, +8.
     * 而n = 4, m = 1, 数列就是: -1, +2, -3, + 4.
     * 小Q现在希望你能帮他算算前n项和为多少。
     *
     * 输入描述:
     * 输入包括两个整数n和m(2 <= n <= 109, 1 <= m), 并且满足n能被2m整除。
     *
     * 输出描述:
     * 输出一个整数, 表示前n项和。
     *
     * 输入例子1:
     * 8 2
     *
     * 输出例子1:
     * 8
     *
     * 很显然，这是一个数学问题
     */

    private static long reverseLiseSum(long n, long m) {
        return m * m * n / (2 * m);
    }

    public static void main(String[] args) throws InterruptedException{
        Scanner cin = new Scanner(System.in);
//        System.out.println(songList(205,1,92,4,92));
        System.out.println(C(4,2));
//        Thread.currentThread().join();
    }


    /**
     * 牛牛和羊羊正在玩一个纸牌游戏。这个游戏一共有n张纸牌, 第i张纸牌上写着数字ai。
     * 牛牛和羊羊轮流抽牌, 牛牛先抽, 每次抽牌他们可以从纸牌堆中任意选择一张抽出, 直到纸牌被抽完。
     * 他们的得分等于他们抽到的纸牌数字总和。
     * 现在假设牛牛和羊羊都采用最优策略, 请你计算出游戏结束后牛牛得分减去羊羊得分等于多少。
     *
     * 输入包括两行。
     * 第一行包括一个正整数n(1 <= n <= 105),表示纸牌的数量。
     * 第二行包括n个正整数ai(1 <= ai <= 109),表示每张纸牌上的数字。
     *
     * 输出一个整数, 表示游戏结束后牛牛得分减去羊羊得分等于多少。
     *
     * 输入例子1:
     * 3
     * 2 7 4
     *
     * 输出例子1:
     * 5
     *
     * 腾讯出题都这么简单吗.....
     *
     */

    private static int cardGame(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i -= 2) {
            res += nums[i];
            res -= i == 0 ? 0 : nums[i - 1];
        }
        return res;
    }

    /**
     * 小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前一天吃的一半，
     * 但是他又不想在父母回来之前的某一天没有巧克力吃，请问他第一天最多能吃多少块巧克力
     *
     * 每个输入包含一个测试用例。
     * 每个测试用例的第一行包含两个正整数，表示父母出差的天数N(N<=50000)和巧克力的数量M(N<=M<=100000)。
     *
     * 输出一个数表示小Q第一天最多能吃多少块巧克力。
     *
     * 输入例子1:
     * 3 7
     *
     * 输出例子1:
     * 4
     */
    private static int eatChocolate(int N, int M) {
        int lo = 1;
        int hi = M;
        while (lo < hi) {
            int mid = hi - (hi - lo) / 2;   // 这里真的太关键了趴， 这里不能是（lo + hi）/ 2 如果lo,hi只相差1的话， 那么mid=lo,如果此时mid是满足题意的，那么程序将死循环了。
            if (canEatChocolateFirstDay(mid, N, M)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private static boolean canEatChocolateFirstDay(int mid, int N, int M) {
        while (N-- > 0) {
            M -= mid;
            if (M < 0) return false;
            mid = (mid & 1) == 1 ? (mid >> 1) + 1 : mid >> 1;
        }
        return true;
    }

    /**
     * 小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，
     * 每首歌最多只能在歌单中出现一次，在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。
     *
     * 每个输入包含一个测试用例。
     * 每个测试用例的第一行包含一个整数，表示歌单的总长度K(1<=K<=1000)。
     * 接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和数量X(X<=100)
     * 以及歌的第二种长度B(B<=10)和数量Y(Y<=100)。保证A不等于B。
     *
     * 输出一个整数,表示组成歌单的方法取模。因为答案可能会很大,输出对1000000007取模的结果。
     *
     * 输入例子1:
     * 5
     * 2 3 3 3
     *
     * 输出例子1:
     * 9
     *
     * 排列组合的问题， 长度为K的歌单中，可能包含0首， 1首， 2首...长度为A的歌单
     */

    private static int songList(int K, int A, int x, int B, int y) {
        long res = 0;
        for (int i = 0; i * A < K && i <= x; i++) {
            if ((K - i * A) % B == 0 && (K - i * A) / B <= y ) {
                res += C(x, i) * C(y, (K - i * A) / B);
                res %= 1000000007;
            }
        }
        return (int)res;
    }

    /**
     * 使用递推公式来求解排列组合数C(m, n)
     *
     * C(m, n) = C(m - 1, n) + C(m - 1, k - 1)
     */

    private static long C(int m, int n) {
        int[][] map = new int[m + 1][n + 1];
        return help(m, n, map);
    }
    private static long help(int m, int n, int[][] map) {
        if (n == 0) {
            map[m][0] = 1;
            return 1;
        } else if (n == 1) {
            map[m][1] = m;
            return m;
        } else if (m == n) {
            map[m][n] = 1;
            return 1;
        }
        long res = 0;
        if (map[m][n] != 0) {
            res = map[m][n];
        } else {
            res = help(m - 1, n, map) + help(m - 1, n - 1, map);
        }
        map[m][n] = (int)res;
        return res;
    }

//    private static long C(long m, long n) {
//        long r = 1;
//        for (int i = 0; i < n; i++) {
//            r *= m - i;
//            r %= 1000000007;
//        }
//        for (int i = 0; i < n; i++) {
//            r /= n - i;
//        }
//        return r;
//    }

}
