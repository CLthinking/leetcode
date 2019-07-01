package com.uestc.leetcode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode lt = new ListNode(0);
        ListNode ge = new ListNode(0);
        ListNode ltCur = lt;
        ListNode geCur = ge;
        while (head != null) {
            if (head.val < x) {
                ltCur.next = head;
                ltCur = ltCur.next;
            } else {
                geCur.next = head;
                geCur = geCur.next;
            }
            head = head.next;
        }
        geCur.next = null;
        ltCur.next = ge.next;
        return lt.next;
    }
}
