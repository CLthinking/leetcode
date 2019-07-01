package com.uestc.leetcode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head, null);
    }
    private TreeNode helper(ListNode head, ListNode end) {
        if (head == end) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != end && fast.next.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, end);
        return root;
    }
}
