package com.uestc.leetcode;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode back = reverseList(slow.next);
        ListNode b = back;
        boolean res = true;
        while (head != null && back != null) {
            if (head.val != back.val) {
                res = false;
                break;
            }
            head = head.next;
            back = back.next;
        }
        reverseList(b);
        return res;
    }

    private static ListNode reverseList (ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.creatListByArray(1,2);
        System.out.println(isPalindrome(head));
    }
}
