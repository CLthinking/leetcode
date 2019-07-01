package com.uestc.leetcode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists0(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // 表头节点，next域指向真正的头结点
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            cur.next = l1.val < l2.val ? l1 : l2;
            cur = cur.next;
            if (l1.val < l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
