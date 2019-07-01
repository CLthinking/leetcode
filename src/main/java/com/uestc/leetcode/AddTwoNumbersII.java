package com.uestc.leetcode;

import java.util.Stack;

public class AddTwoNumbersII {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        while (l1 != null) {st1.push(l1.val); l1 = l1.next;}
        while (l2 != null) {st2.push(l2.val); l2 = l2.next;}

        ListNode dummy = new ListNode(0);
        int sum = 0;
        while (!st1.isEmpty() || !st2.isEmpty() || sum != 0) {
            sum += st1.isEmpty() ? 0 : st1.pop();
            sum += st2.isEmpty() ? 0 : st2.pop();
            dummy.next = new ListNode(sum % 10, dummy.next);
            sum /= 10;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListUtil.creatListByArray(7,2,4,3);
        ListNode l2 = ListUtil.creatListByArray(5,6,4);
        addTwoNumbers(l1,l2);
    }
}
