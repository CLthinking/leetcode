package com.uestc.leetcode;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if(root == null) return null;
        Node left = connect(root.left);
        Node right = connect(root.right);
        while(left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        return root;
    }
}
