package com.uestc.leetcode;

import java.util.*;

public class NextGreaterElementI {
    /**
     * LeetCode--496. Next Greater Element I https://leetcode.com/problems/next-greater-element-i/description/
     * findNum是nums中的一个子数组，函数功能是找到findNum中的每一个数字在num中右边第一个比它大的数字。
     * 基于这样一个事实：【5,4,3,2,1,6】必5 4 3 2 1大的都是6，所以我们一直找到递减序列，实现O(n)的复杂度
     * @param findNum
     * @param nums
     * @return
     */
    public int[] nextGreaterElement(int[] findNum, int[] nums) {
        if (findNum == null || findNum.length == 0 || nums == null || nums.length == 0) return new int[0];
        int[] res = new int[findNum.length];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        for (int i = 0; i < findNum.length; i++) {  // 先对nums进行了预处理，将所有的结果都保存在了map中，然后在map里面查找
            res[i] = map.getOrDefault(findNum[i], -1);
        }
        return res;
    }

    /**
     * 在单个数组中查找下一个最大元素
     * @param nums
     * @return
     */
    private static int[] nextGreaterElement0(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                res[st.pop()] = nums[i];
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.getRandomArray();
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nextGreaterElement0(nums)));
    }

}

