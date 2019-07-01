package com.uestc.leetcode;

public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };
    public Node flatten(Node head) {
        helper(head);
        return head;
    }
    private Node helper(Node head) {
        if (head == null) return null;
        Node cur = head;
        Node tail = null;
        while (cur != null) {
            if (cur.child != null) {
                Node next = cur.next;
                Node childTail = helper(cur.child);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                childTail.next = next;
                if (next != null) next.prev = childTail;
                cur = next;
                tail = childTail;
                continue;
            }
            tail = cur;  // 这一句必须有，如果函数一直不能进入if语句，则应该返回最后一个节点
            cur = cur.next;
        }
        return tail;
    }
}
