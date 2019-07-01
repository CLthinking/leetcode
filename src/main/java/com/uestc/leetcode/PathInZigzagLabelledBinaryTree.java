package com.uestc.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    public static List<Integer> pathInZigZagTree0(int label) {
        LinkedList<Integer> res = new LinkedList<>();
        res.addFirst(label);
        label >>= 1;
        int flag = 1;
        while (label >= 1) {
            if ((flag & 1) == 1) {
                int step = nextPowerTwoMinusOne(label) - label;
                res.addFirst(Integer.highestOneBit(label) + step);
            } else {
                res.addFirst(label);
            }
            label >>= 1;
            flag++;
        }
        return res;
    }

    public static List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> res = new LinkedList<>();
        int flag = 0;
        do {
            if ((flag & 1) == 0) {
                res.addFirst(label);
            } else {
                int gap = nextPowerTwoMinusOne(label) - label;
                res.addFirst(Integer.highestOneBit(label) + gap);
            }
            label >>= 1;
            flag++;
        } while (label >= 1);

        return res;
    }

    public static void main(String[] args) {

        System.out.println(pathInZigZagTree(14));

    }
    private static int nextPowerTwoMinusOne(int i) {
        i |= i >> 1;
        i |= i >> 2;
        i |= i >> 4;
        i |= i >> 8;
        i |= i >> 16;

        return i;
    }
}
