package com.uestc.leetcode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1 ; i < m; i++) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        for (int i = 0; i < m - n; ++i) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
    public ListNode reverseBetween0(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode prev = node;
        for(int i = 1; i < m; i++) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        // 这里的思想类似于插入排序，前面都是已经逆序了的。
        for(int i = 0; i < n - m; i++) {
            ListNode move = cur.next;
            cur.next = move.next;
            move.next = prev.next;
            prev.next = move;
        }
        return node.next;
    }
}
