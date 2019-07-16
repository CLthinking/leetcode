package com.uestc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FourSumII {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Long> map =  Arrays.stream(A)
                .flatMap(i -> Arrays.stream(B).map(j -> i + j))
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return Arrays.stream(C)
                .flatMap(i -> Arrays.stream(D).map(j -> i + j))
                .map(i ->  map.getOrDefault(-i, 0L).intValue())
                .sum();

//        Map<Integer, Integer> map = new HashMap<>();
//        for (int a : A) {
//            for (int b : B) {
//                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
//            }
//        }
//        int res = 0;
//        for (int c : C) {
//            for (int d : D) {
//                res += map.getOrDefault(-(c + d), 0);
//            }
//        }
//        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        System.out.println(fourSumCount(A, B, C, D));

    }
}
