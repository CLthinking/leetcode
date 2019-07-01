package com.uestc.leetcode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists0(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode res = null;
        for (ListNode l : lists) {
            res = mergeTwoLists(l, res);
        }
        return res;
    }
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode node : lists)
            if (node != null)
                pq.add(node);

        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }
        return dummy.next;
    }
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKLists2(lists, 0, lists.length);
    }
    private ListNode mergeKLists2(ListNode[] lists, int start, int stop) {
        if (start + 1 == stop) return lists[start];
        return mergeTwoLists(mergeKLists2(lists, start, (start + stop) / 2),
                mergeKLists2(lists, (start + stop) / 2, stop));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
