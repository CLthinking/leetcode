package com.uestc.leetcode;

public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode helper = new ListNode(-1);
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            ListNode n = findInsertPosition(helper, cur);
            linkAfter(n, cur);
            cur = next;
        }
        return helper.next;
    }

    private static ListNode findInsertPosition(ListNode head, ListNode node) {
        while (head.next != null && head.next.val < node.val) {
            head = head.next;
        }
        return head;
    }

    private static void linkAfter(ListNode prev, ListNode node) {
        node.next = prev.next;
        prev.next = node;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.getRandomList();
        System.out.println(ListUtil.toString(head));
        System.out.println(ListUtil.toString(insertionSortList(head)));
    }
}
