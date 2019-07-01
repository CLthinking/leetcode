package com.uestc.leetcode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode n = head.next;
        head.next = swapPairs(n.next);
        n.next = head;
        return n;
    }
}
