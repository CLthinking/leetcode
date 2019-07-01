package com.uestc.fft;

import com.uestc.leetcode.ArrayUtil;

import java.util.Arrays;

public class FFT {
    public static Complex[] fft(double[] nums) {
        if (nums == null || nums.length == 0 || Util.isNotPowerOfTwo(nums.length)) {
            throw new RuntimeException("Sorry! the input length must be power of two");
        }
        if (nums.length == 2) {
            return new Complex[]{
                    new Complex().setX(nums[0] + nums[1]),
                    new Complex().setX(nums[0] - nums[1])
            };
        }
        int N = nums.length;
        int halfN = N / 2;
        double[] even = new double[halfN];
        double[] odd = new double[halfN];
        for (int i = 0; i < halfN; i++) {
            even[i] = nums[2 * i];
            odd[i] = nums[2 * i + 1];
        }
        Complex[] evenRes = fft(even);
        Complex[] oddRes = fft(odd);
        Complex[] res = new Complex[N];
        for (int i = 0; i < halfN; i++) {
            res[i] = Util.add(evenRes[i], Util.multiply(Util.W(N, i), oddRes[i]));
        }
        for (int i = 0; i < halfN; i++) {
            res[i + halfN] = Util.minux(evenRes[i], Util.multiply(Util.W(N, i), oddRes[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        double[] nums = {1,2,3,4,4,3,2,1};
        System.out.println(ArrayUtil.toString(fft(nums)));
    }

}
