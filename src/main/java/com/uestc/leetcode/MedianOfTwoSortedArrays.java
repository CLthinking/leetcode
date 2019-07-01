package com.uestc.leetcode;

import java.util.ServiceLoader;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays0(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return getMid(nums2);
        if (nums2 == null || nums2.length == 0) return getMid(nums1);
        int sum = nums1.length + nums2.length;
        int mid = (sum & 1) == 0 ? sum - 1 : sum;
        mid >>= 1;
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i + j == mid) break;
            int num1 = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int num2 = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;
            if (num1 < num2) {
                i++;
            } else {
                j++;
            }
        }
        int num1 = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
        int num2 = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;
        if ((sum & 1) == 1) return Math.min(num1, num2);
        if (Math.min(num1, num2) == num1) {
            int num3 = (i + 1) < nums1.length ? nums1[i + 1] : Integer.MAX_VALUE;
            return (num1 + Math.min(num2, num3)) / 2.0;
        } else {
            int num3 = (j + 1) < nums2.length ? nums2[j + 1] : Integer.MAX_VALUE;
            return (num2 + Math.min(num1, num3)) / 2.0;
        }
    }

    private static double getMid(int[] nums) {
        int len = nums.length;
        return (len & 1) == 1 ? nums[len / 2] : (nums[len / 2] + nums[len / 2 - 1]) / 2.0;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 确保 m <= n ，这样就可以保证 （m + n + 1）/ 2 - [0...m] >= 0 了
        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int lo = 0;
        int hi = m;
        int half = (m + n + 1) / 2;
        double res = 0;
        int len = m + n;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int i = mid;
            int j = half - i;

            int maxLeft1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int maxLeft2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];

            int minRight1 = i == m ? Integer.MAX_VALUE : nums1[i];
            int minRight2 = j == n ? Integer.MAX_VALUE : nums2[j];


            if (minRight1 >= maxLeft2 && minRight2 >= maxLeft1){
                if ((len & 1) == 1) {
                    res = Math.max(maxLeft1, maxLeft2);
                } else {
                    res = (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
                break;
            } else if (maxLeft1 > minRight2) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
}
