package com.uestc.leetcode;

public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node = slow.next;
        slow.next = null;
        node = reverseList(node);
        while (node != null) {
            ListNode headNext = head.next;
            ListNode nodeNext = node.next;
            head.next = node;
            node.next = headNext;
            head = headNext;
            node = nodeNext;
        }

    }
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.creatListByArray(1,2,3,4,5);
        reorderList(head);
        System.out.println(ListUtil.toString(head));
    }
}
