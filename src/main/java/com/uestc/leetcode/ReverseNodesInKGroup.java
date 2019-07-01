package com.uestc.leetcode;

public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup0(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;
        ListNode cur = head;
        int num = k;
        while (num-- > 0 && cur != null) {
            cur = cur.next;
        }
        if (num != -1) return head;  // 说明不够k,直接返回。
        ListNode res = reverseList(head, cur);
        head.next = reverseKGroup0(cur, k);
        return res;
    }
    private static ListNode reverseList(ListNode head, ListNode end) {
        if (head == null || head.next == end) return head;
        ListNode res = reverseList(head.next, end);
        head.next.next = head;
        head.next = null;
        return res;
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {  // 说明此时还有k个结点用来交换
            ListNode prev = reverseKGroup(cur, k);
            ListNode next = null;
            cur = head;
            while (count-- != 0) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = ListUtil.creatListByArray(1,2,3,4,5);
        head = reverseKGroup(head, 3);
        System.out.println(ListUtil.toString(head));
    }
}

