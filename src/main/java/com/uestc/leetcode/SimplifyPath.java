package com.uestc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        String[] strs = path.split("/");
        Deque<String> Q = new ArrayDeque<>();
        for (String str : strs) {
            if (str .equals(".") || str.equals("")) continue;
            else if (str.equals("..")) Q.pollLast();
            else Q.addLast(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (String str : Q) {
            sb.append(str);
            sb.append("/");
        }
        String res = sb.toString().substring(0, sb.lastIndexOf("/"));
        return res.length() == 0 ? "/" : res;
    }

    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(path));
    }

}
