package com.uestc.leetcode;

/**
 * @author CLthinking
 * @date 2019/7/12 下午 02:46
 */
public class FibonacciNumber {

    /**
     * FibonacciNumber 线性时间求解算法
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int num1 = 0, num2 = 1;
        int res = 0;
        while (N-- >= 2) {
            res = num1 + num2;
            num1 = num2;
            num2 = res;
        }
        return res;
    }

    /**
     * F(N) = F(N-1)+F(N-2); F(N-1) = F(N-1)
     *                                         | 1   1 |
     * [F(N) , F(N-1)] =  [F(N-1) , F(N-2)]  * |       |
     *                                         | 1   0 |
     */
    private int[][] matrixPower(int[][] mtx, int n) {
        int[][] res = new int[mtx.length][mtx[0].length];
        for (int i = 0; i < mtx.length; i++) {
            res[i][i] = 1;
        }

        int[][] tmp = mtx;
        for (; n != 0; n >>= 1) {
            if ((n & 1) == 1) {
                res = multiMtx(res, tmp);
            }
            tmp = multiMtx(tmp, tmp);
        }
        return res;
    }

    private int[][] multiMtx(int[][] mtx1, int[][] mtx2) {
        int[][] res = new int[mtx1.length][mtx2[0].length];
        for (int i = 0; i < mtx1.length; i++) {
            for (int j = 0; j < mtx2[0].length; j++) {
                for (int k = 0; k < mtx1[0].length; k++) {
                    res[i][j] += mtx1[i][k] * mtx2[k][j];
                }
            }
        }
        return res;
    }


    /**
     * FibonacciNumber O(lgn) 时间复杂度算法
     * @param N
     * @return
     */
    public int fib2(int N) {
        if (N <= 0) return 0;
        if (N == 1 || N == 2) return 1;
        int[][] base = {{1,1}, {1,0}};
        int[][] res = matrixPower(base, N - 2);
        return res[0][0] + res[1][0];
    }


    /**
     * 跳台阶问题，每次可以跳1次或者2次，一共有n阶台阶，请问一共有多少种跳法。
     * f(n) = f(n - 1) + f(n - 2); n = 1, return 1; n = 2, return 2;
     *                                          | 1   1 |
     * [F(N) , F(N-1)] =  [F(N-1) , F(N-2)]  * |       |
     *                                        | 1   0 |
     *
     *
     *  线性时间复杂度
     * @param N
     */
    public int jumpStep(int N) {
        if (N < 1) return 0;
        if (N == 1 || N == 2) return N;
        int num1 = 1; int num2 = 2;
        int res = 0;
        while (N-- > 2) {
            res = num1 + num2;
            num1 = num2;
            num2 = res;
        }
        return res;
    }

    /**
     * 跳台阶O(lgn)复杂度算法
     * @param N
     * @return
     */
    public int jumpStep2(int N) {
        if (N < 1) return 0;
        if (N == 1 || N == 2) return N;
        int[][] base = {{1,1}, {1, 0}};
        int[][] res = matrixPower(base, N - 2);
        return 2 * res[0][0] + res[1][0];
    }


    /**
     * 母牛生牛问题，牛永远不会死，一头成熟的牛每年生一头牛，新出生的牛三年后成熟，问第一年一头牛，N年后几头牛
     * n = 1, return 1; n = 2, return 2; n = 3, return 3; n = 4, return 4; n = 5, return 6(第二年生的小牛成熟了)
     * C(N) = C(N - 1){去年的牛} + C(N - 3){三年前的牛，都成熟了} 故，C(N) = C(N - 1) + C(N - 3)
     *                                                              | 1   1   0|
     * [C(N) , C(N-1), C(N - 2)] =  [C(N-1) , C(N-2), C(N - 3)]  * | 0   0   1|
     *                                                            | 1   0   0|
     *
     *                                3      2      1     | 1   1   0| ^ N - 3
     *  [C(N) , C(N-1), C(N - 2)] = [C(3), C(2), C(1)] * | 0   0   1|
     *                                                  | 1   0   0|
     *
     *  母牛生牛线性解法
     * @param N
     */

    public int cowBrithBaby(int N) {
        if (N < 1) return 0;
        if (N == 1 || N == 2 || N == 3) return N;
        int n1 = 1, n2 = 2, n3 = 3;
        int res = 0;
        while (N-- > 3) {
            res = n1 + n3;
            n1 = n2;
            n2 = n3;
            n3 = res;
        }
        return res;
    }

    public int cowBrithBaby1(int N) {
        if (N < 1) return 0;
        if (N == 1 || N == 2 || N == 3) return N;
        int[][] base = {{1,1,0}, {0,0,1}, {1,0,0}};
        int[][] res = matrixPower(base, N - 3);
        return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
    }


    public static void main(String[] args) {
        FibonacciNumber test = new FibonacciNumber();
        System.out.println(test.fib(20));
        System.out.println(test.fib2(20));
        System.out.println(test.jumpStep(20));
        System.out.println(test.jumpStep2(20));
        System.out.println(test.cowBrithBaby(20));
        System.out.println(test.cowBrithBaby1(20));
    }

}
