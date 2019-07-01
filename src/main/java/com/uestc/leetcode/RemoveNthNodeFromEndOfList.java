package com.uestc.leetcode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd0(ListNode head, int n) {
        if (head == null) return null;
        ListNode dumb = new ListNode(-1);
        dumb.next = head;
        ListNode front = dumb;
        ListNode back = dumb;
        while (front.next != null) {
            front = front.next;
            if (n-- <= 0) {
                back = back.next;
            }
        }
        back.next = back.next.next;
        return dumb.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = dummy, back = dummy;
        for (int i = 0; i < n + 1; i++) {
            front = front.next;
        }
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}
