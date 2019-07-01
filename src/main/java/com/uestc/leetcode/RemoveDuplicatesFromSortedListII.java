package com.uestc.leetcode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (prev.next == cur) {
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    public ListNode deleteDuplicates0(ListNode head) {
        return helper(head, null);
    }
    private ListNode helper(ListNode cur, ListNode prev) {
        if (cur == null) {
            return null;
        }
        if (cur.next != null && cur.next.val == cur.val || prev != null && prev.val == cur.val) {
            return helper(cur.next, cur);
        } else {
            cur.next = helper(cur.next, cur);
            return cur;
        }
    }
}
