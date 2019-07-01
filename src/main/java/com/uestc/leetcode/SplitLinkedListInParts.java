package com.uestc.leetcode;

public class SplitLinkedListInParts {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null ) return new ListNode[k];
        int len = getLinkedListLength(root);
        ListNode[] res = new ListNode[k];
        int small = len / k;
        int largeNum = len % k;
        int idx = 0;
        while (root != null) {
            ListNode bak = root;
            int step = largeNum > 0 ? small : small - 1;
            largeNum--;
            while (step-- > 0) {
                root = root.next;
            }
            ListNode next = root.next;
            root.next = null;
            res[idx++] = bak;
            root = next;
        }
        return res;
    }
    private static int getLinkedListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ListNode head = ListUtil.creatListByArray(nums);
        splitListToParts(head,5);
    }
}
