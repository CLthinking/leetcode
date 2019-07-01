package com.uestc.bytedance;

import com.uestc.leetcode.ArrayUtil;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class NO2 {

    private static int no2(int[] nums, int val) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int idx = findIndex(nums, i + 1, val + nums[i]);
            if (idx - i >= 2) {
                res += (idx - i) * (idx - i - 1) / 2;
            }
        }
        return res;
    }
    private static int findIndex(int[] nums, int start, int target) {
        int lo = start;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return hi;
    }

    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int num = cin.nextInt(); int val = cin.nextInt();
//        int[] nums = new int[num];
//        for (int i = 0; i < num; i++) {
//            nums[i] = cin.nextInt();
//        }
//        System.out.println(no2(nums, val));
//        int[] nums = {1,2,5,9,10,15,18,19,20,26,30,38,40,50,80,100};
//        int val = 60;
//        System.out.println(no2(nums, val));
//        System.out.println(arrest2(nums, val));
        test();
        System.out.println("done");
        //System.out.println(Arrays.toString(ArrayUtil.getRandomArrayNoRepeat(10,0,20)));
    }

    private static void test() {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 100; i++) {
            int[] nums = ArrayUtil.getRandomArrayNoRepeat(50,0,100);
            int val = random.nextInt(30) + 5;
            Arrays.sort(nums);
            if (no2(nums, val) == arrest2(nums, val)) {
                System.out.println(Arrays.toString(nums) + " " + val) ;
                System.out.println(no2(nums, val));
                System.out.println(arrest2(nums,val));
                System.out.println(i);
            }
        }
    }

    private static int arrest2(int a[], int d) {
        long res = 0;
        int n = a.length;
        for (int i = 0,j=1; i < n-2; i++) {
            while(j<n&&a[j]-a[i]<=d)j++;
            j--;
            if(j-i>=2){
                res=res+(long)(j-i)*(j-i-1)/2;
            }
        }
        return (int)(res%99997867);
    }



}
