package com.uestc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 01:22
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, sb, n, 0, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, int n, int left, int right) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            helper(res, sb, n, left + 1, right);
            sb.setLength(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            helper(res, sb, n, left, right + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
