package com.uestc.leetcode;

import java.util.HashMap;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        while (headA != null) {
            if (hasNodeInHead(headA, headB)) return headA;
            headA = headA.next;
        }
        return null;
    }
    private boolean hasNodeInHead(ListNode node, ListNode head) {
        while (head != null) {
            if (head == node) return true;
            head = head.next;
        }
        return false;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
