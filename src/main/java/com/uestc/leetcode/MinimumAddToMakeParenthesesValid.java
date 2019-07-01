package com.uestc.leetcode;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } else {
                st.push(c);
            }
        }
        return st.size();
    }
}
