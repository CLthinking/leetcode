package com.uestc.leetcode;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int res = 0;
        int lo = 0;
        int hi = height.length - 1;
        while (lo < hi) {
            int min = Math.min(height[lo], height[hi]);
            res = Math.max(res, min * (hi - lo));
            while (lo < hi && height[lo ] <= min) lo++;
            while (lo < hi && height[hi ] <= min) hi--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
