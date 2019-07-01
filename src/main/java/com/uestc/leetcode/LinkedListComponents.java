package com.uestc.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : G) set.add(i);
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) res++;
            head = head.next;
        }
        return res;
    }
}
