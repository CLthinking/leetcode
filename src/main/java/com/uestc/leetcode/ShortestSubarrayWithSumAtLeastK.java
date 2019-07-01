package com.uestc.leetcode;

import java.util.*;

public class ShortestSubarrayWithSumAtLeastK {
    public static int shortestSubarray(int[] A, int K) {
        int N = A.length;
        int res = Integer.MAX_VALUE;
        int[] sum = new int[N + 1];
        for (int i = 0; i < N; ++i) sum[i + 1] = sum[i] + A[i];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < sum.length; i++) {
            while (!deque.isEmpty() && sum[i] - sum[deque.getFirst()] >= K) {
                res = Math.min(res, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && sum[i] <= sum[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] A = {2,-1,2};
        shortestSubarray(A, 3);
    }
}
