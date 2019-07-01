package com.uestc.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i%n];
            while (!st.isEmpty() && num> nums[st.peek()]) {
                res[st.pop()] = num;
            }
            if (i < n) st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.getRandomArray();
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
