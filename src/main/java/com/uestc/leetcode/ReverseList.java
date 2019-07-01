package com.uestc.leetcode;

public class ReverseList {
    public static ListNode reverseListIter (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode reverseListRecur (ListNode head) {
        if (head == null || head.next == null) {
            return  head;
        }
        ListNode node = reverseListRecur(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode q = head.next, p = null;
        head.next = null;
        while (q != null) {
            head.val = q.val;//先改数据，反正对指针指向无影响
            p = q.next;//q->next要转向用p暂存
            q.next = head;//q->next转向
            head = q;//head,q向后移动一位
            q = p;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = ListUtil.creatListByArray(new int[]{5,1,2,3,4,5});
        System.out.println(ListUtil.toString(head));
        head = reverseList(head);
        System.out.println(ListUtil.toString(head));
    }
}
