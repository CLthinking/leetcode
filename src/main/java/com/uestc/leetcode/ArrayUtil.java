package com.uestc.leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayUtil {
    // 不容易生成实例
    private ArrayUtil(){};

    public static final int[] EMPTY_INT_ARRAY = new int[0];

    public static void swap(int[] nums, int i, int j) {
        if (nums == null || i < 0 || j >= nums.length) return;
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }

    public static void reverse(int[] nums, int i, int j) {
        if (nums == null) return;
        if (i < 0 || j > nums.length || j <= i) {
            throw new RuntimeException("输入参数不合法");
        }
        j--;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void reverse(int[] nums, int i) {
        reverse(nums, i, nums.length);
    }

    public static void reverse(int[] nums) {
        reverse(nums, 0);
    }

//    public static int[] creatArrayByIntNum(int num) {
//        List<int>
//    }

    /**
     * 生成一个随机数组，大小为size,随机值的下限为lowBoundInclusive（包含），上限为upBoundExclusive（不包含）
     * @param size
     * @param lowBoundInclusive
     * @param upBoundExclusive
     * @return
     */
    public static int[] getRandomArray(int size, int lowBoundInclusive, int upBoundExclusive) {
        if (size <= 0) {
            throw new RuntimeException("size 不能为负数");
        }
        if (upBoundExclusive <= lowBoundInclusive) {
            throw new RuntimeException("输入upBound与lowBound不合法，upBound必须必lowBound大");
        }
        int[] nums = new int[size];
        SecureRandom random = new SecureRandom();
        int span = upBoundExclusive - lowBoundInclusive;
        for (int i = 0; i < size; i++) {
            nums[i] = random.nextInt(span) + lowBoundInclusive;
        }
        return nums;
    }

    public static int[] getRandomArrayNoRepeat(int size, int lowBoundInclusive, int upBoundExclusive) {
        if (size <= 0) {
            throw new RuntimeException("size 不能为负数");
        }
        if (upBoundExclusive <= lowBoundInclusive) {
            throw new RuntimeException("输入upBound与lowBound不合法，upBound必须必lowBound大");
        }
        if (size > upBoundExclusive - lowBoundInclusive) {
            throw new  RuntimeException("size太大了");
        }
        int[] nums = new int[size];
        Set<Integer> set = new HashSet<>();
        SecureRandom random = new SecureRandom();
        int span = upBoundExclusive - lowBoundInclusive;
        for (int i = 0; i < size; i++) {
            int num = random.nextInt(span) + lowBoundInclusive;
            while (set.contains(num)) {
                num = random.nextInt(span) + lowBoundInclusive;
            }
            nums[i] = num;
            set.add(num);
        }
        return nums;
    }

    public static int DEFAULT_ARRAY_SIZE = 10;
    public static int DEFAULT_LOWBOUND = 0;
    public static int DEFAULT_UPBOUND = 11;

    public static int[] getRandomArray(int size, int upBoundExclusive) {
        return getRandomArray(size, DEFAULT_LOWBOUND, upBoundExclusive);
    }

    public static int[] getRandomArray(int size) {
        return getRandomArray(size, DEFAULT_LOWBOUND, DEFAULT_UPBOUND);
    }

    public static int[] getRandomArray() {
        return getRandomArray(DEFAULT_ARRAY_SIZE, DEFAULT_LOWBOUND, DEFAULT_UPBOUND);
    }

    public static int[] DEFAULT_ARRAY = {1,2,3,4,5,6,7,8,9,10};

    public static <T> String toString(T[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (T item : arr) {
            sb.append(item.toString());
            sb.append(", ");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = DEFAULT_ARRAY;
        reverse(nums,0,10);
        System.out.println(Arrays.toString(nums));
    }
}
