package com.uestc.leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    /**
     * LeetCode--1019. Next Greater Node In Linked List https://leetcode.com/problems/next-greater-node-in-linked-list/description/
     * 考虑这样一个序列【6,5,4,3,2,1,7】 ，那么显然 6,5,4,3,2,1下一个比它大的元素肯定是7，我们我们只需要一直维护一个递减的序列即可了
     * @param head
     * @return
     */
    public static int[] nextLargerNodes2(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }

    // version1 O(n^2) 没什么好说的了，两层循环
    public static int[] nextLargerNodes1(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(nexLarger(head));
            head = head.next;
        }
        return ArrayUtils.toPrimitive(list.toArray(new Integer[0]));
    }

    private static int nexLarger(ListNode cur) {
        int num = cur.val;
        while (cur != null && cur.val <= num) {
            cur = cur.next;
        }
        return cur == null ? 0 : cur.val;
    }



    public static void main(String[] args) {
        ListNode head = ListUtil.getRandomList();
        System.out.println(ListUtil.toString(head));
        System.out.println(Arrays.toString(nextLargerNodes1(head)));

    }

}
