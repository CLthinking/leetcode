package com.uestc.leetcode;

import java.util.Stack;

public class BinarySearchTreeToGreaterSumTree {
    // 右，中，左遍历即可
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        TreeNode cur = root;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}
