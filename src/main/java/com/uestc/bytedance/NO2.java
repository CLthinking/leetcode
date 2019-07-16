package com.uestc.bytedance;

import com.uestc.leetcode.ArrayUtil;

import java.security.SecureRandom;
import java.util.Arrays;

public class NO2 {

    private static int no2(int[] nums, int val) {
        //Arrays.sort(nums);
        long res = 0;
        for (int i = 0, j = 0; i < nums.length - 2; i++) {
            while ((j = Math.max(j, i + 2)) < nums.length && nums[j] - nums[i] <= val) j++;
            if (j - i > 2) {
                res += (j - i - 1) * (j - i - 2) / 2;
                res %= 99997867;
            }
        }
        return (int)res;
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
//        test();
//        System.out.println("done");
        //System.out.println(Arrays.toString(ArrayUtil.getRandomArrayNoRepeat(10,0,20)));

        int[] nums = {1,2,3,4};
        System.out.println(no2(nums, 3));
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
