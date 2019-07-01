package com.uestc.leetcode;

public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if (root == null) return null;
        Node left = connect(root.left);
        Node right = connect(root.right);
        while (left != null && right != null) {
            left.next = right;
            left = left.right != null ? left.right : left.left;
            right = right.left != null ? right.left : right.right;
        }
        return root;
    }
}
