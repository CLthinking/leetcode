package com.uestc.leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtil {
    // 不容许生成实例
    private ListUtil() {};
    /**
     * 根据数组生成一个单向链表，返回头结点
     * @param nums
     * @return
     */
    public static ListNode creatListByArray(int... nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; ++i) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    public static ListNode DEFAULT_LIST = creatListByArray(ArrayUtil.DEFAULT_ARRAY);

    public static ListNode getRandomList(int size, int lowBoundInclusive, int upBoundExclusive) {
        return creatListByArray(ArrayUtil.getRandomArray(size,lowBoundInclusive, upBoundExclusive));
    }

    public static ListNode getRandomList(int size, int upBoundExclusive) {
        return creatListByArray(ArrayUtil.getRandomArray(size, upBoundExclusive));
    }

    public static ListNode getRandomList(int size) {
        return creatListByArray(ArrayUtil.getRandomArray(size));
    }

    public static ListNode getRandomList() {
        return creatListByArray(ArrayUtil.getRandomArray());
    }

    public static String toString(ListNode head) {
        if (head == null) {
            return "[ ]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        while (head.next != null) {
            sb.append(head.val);
            sb.append(" -> ");
            head = head.next;
        }
        sb.append(head.val);
        sb.append(" ]");
        return sb.toString();
    }

    public static int[] toArray(ListNode head) {
        if (head == null) return ArrayUtil.EMPTY_INT_ARRAY;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return ArrayUtils.toPrimitive(list.toArray(new Integer[0]));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(toArray(getRandomList())));
    }
}
