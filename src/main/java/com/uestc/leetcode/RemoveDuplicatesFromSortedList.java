package com.uestc.leetcode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates0(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur != null) {
            cur.next = helpDelete(cur.next, cur.val);
            cur = cur.next;
        }
        return head;
    }
    private ListNode helpDelete(ListNode head, int val) {
        if (head == null) return null;
        while (head != null && head.val == val) {
            head = head.next;
        }
        return head;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
