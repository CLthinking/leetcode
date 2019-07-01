package com.uestc.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node n = new Node(cur.val, cur.next, null);
            cur.next = n;
            cur = n.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node res = cur.next;
        while (cur.next.next != null) {
            Node next = cur.next.next;
            cur.next.next = next.next;
            cur.next = next;
            cur = cur.next;
        }
        cur.next = null;
        return res;
    }
    public Node copyRandomList0(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node n = new Node(cur.val, null, null);
            map.put(cur, n);
            cur = cur.next;
        }
        Node res = map.get(head);
        cur = head;
        while (cur != null) {
            Node n = map.get(cur);
            n.next = map.getOrDefault(cur.next, null);
            n.random = map.getOrDefault(cur.random, null);
            cur = cur.next;
        }
        return res;
    }
}
