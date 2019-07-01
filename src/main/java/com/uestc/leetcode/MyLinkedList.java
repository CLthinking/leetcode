package com.uestc.leetcode;

public class MyLinkedList {

    private int size;
    private ListNode dummy = new ListNode(-1);
    private ListNode tail = dummy;

    /** Initialize your data structure here. */
    public MyLinkedList() {}

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (!checkIndex(index)) return -1;
        ListNode cur = dummy;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        dummy.next = new ListNode(val, dummy.next);
        if (tail == dummy) tail = dummy.next;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == size) {addAtTail(val);return;}
        if (index < 0) {addAtHead(val);return;}
        if (!checkIndex(index)) return;
        ListNode cur = dummy;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = new ListNode(val, cur.next);
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (!checkIndex(index)) return;
        ListNode cur = dummy;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        if (index == size - 1) tail = cur;
        cur.next = cur.next.next;
        size--;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(4,2);
        linkedList.get(1);
        linkedList.deleteAtIndex(-1);
        linkedList.get(1);
    }
}
