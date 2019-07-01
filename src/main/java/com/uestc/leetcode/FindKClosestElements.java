package com.uestc.leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) return null;
        int lo = 0;
        int hi = arr.length - 1;
        int idx = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int midNum = arr[mid];
            if (midNum < x) {
                lo = mid + 1;
            } else if (midNum > x) {
                hi = mid - 1;
            } else {
                idx = mid;
                break;
            }
        }
        if (idx == -1) {
            if (lo == arr.length) idx = hi;
            else if (hi == -1) idx = lo;
            else idx = Math.abs(arr[lo] - x) <= Math.abs(arr[hi] - x) ? lo : hi;
        }

        LinkedList<Integer> res = new LinkedList<>();


        res.add(arr[idx]);
        lo = idx - 1;
        hi = idx + 1;

        while (lo >= 0 && hi < arr.length && res.size() < k) {
            if (Math.abs(arr[lo] - x) <= Math.abs(arr[hi] - x)) {
                res.addFirst(arr[lo]);
                lo--;
            } else {
                res.addLast(arr[hi]);
                hi++;
            }
        }
        while (res.size() < k) {
            if (lo >= 0) {
                res.addFirst(arr[lo--]);
            } else {
                res.addLast(arr[hi++]);
            }
        }
        return res;
    }
}
