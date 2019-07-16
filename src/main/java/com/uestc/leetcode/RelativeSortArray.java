package com.uestc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author CLthinking
 * @date 2019/7/14 上午 10:35
 */
public class RelativeSortArray {
    public int[] relativeSortArray0(int[] arr1, int[] arr2) {

        Map<Integer, Long> map1 = Arrays.stream(arr1).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> list = new ArrayList<>(arr1.length);

        for (int num : arr2) {
            for (int i = 0; i < map1.get(num); i++) {
                list.add(num);
            }
            map1.remove(num);
        }

        List<Integer> list1 = new ArrayList<>();
        for (Map.Entry<Integer, Long> entry : map1.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                list1.add(entry.getKey());
            }
        }
        list1.sort(null);
        list.addAll(list1);

        int[] res = new int[arr1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int idx = 0;
        int[] map = new int[1001];
        int[] res = new int[arr1.length];
        for (int n : arr1) {
            map[n]++;
        }
        for (int n : arr2) {
            while (map[n]-- > 0) {
                res[idx++] = n;
            }
        }
        for (int i = 0; i < map.length; i++) {
            while (map[i]-- > 0) {
                res[idx++] = i;
            }
        }
        return res;
    }
}
