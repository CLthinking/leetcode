package com.uestc.leetcode;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers0(int[] flowerbed, int n) {
        int N = flowerbed.length;
        if (N > 2 && flowerbed[0] == 0 && flowerbed[1] == 0) {
            n--;
            flowerbed[0] = 1;
        } else if (N == 1 && flowerbed[0] == 0) {
            n--;
        }
        for (int i = 1; i < N - 1; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }
        if (N >= 2 && flowerbed[N - 2] == 0 && flowerbed[N - 1] == 0) {
            n--;
            flowerbed[N - 1] = 1;
        }
        return n <= 0;
    }


    // 这种设计哨兵的方式要学会使用啊！！确实能节省不少代码量，巧用三目运算符！！
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if (flowerbed[i] == 0) {
                int prev = i == 0 ? 0 : flowerbed[i - 1];
                int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
                if (prev == 0 && next == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        return count == n;
    }
}
