package com.uestc.leetcode;

public class SortList {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    private static ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.getRandomList();
        System.out.println(ListUtil.toString(sortList(head)));
    }
}
