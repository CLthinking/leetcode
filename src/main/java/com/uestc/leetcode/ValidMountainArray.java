package com.uestc.leetcode;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;
        int N = A.length;
        int i = 0;
        while (i < N - 1 && A[i] < A[i + 1]) i++;
        int j = N - 1;
        while (j > 0 && A[j] < A[j - 1]) j--;
        return i == j && i != N - 1 && j != 0;
    }
}
