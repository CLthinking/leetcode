package com.uestc.jdk8;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperateTest {

    public static void main(String[] args) {
        BinaryOperateTest test = new BinaryOperateTest();
        System.out.println(test.operate(2, 3, Integer::sum));
        System.out.println(test.operate(2, 3, (a, b) -> a - b));
        System.out.println(test.operate(2, 3, (a, b) -> a * b));
        System.out.println(test.operate(2, 3, BinaryOperator.minBy(Integer::compareTo)));

        System.out.println(test.getShort("hello 123", "world", Comparator.comparingInt(String::length)));
    }

    public String getShort(String a, String b , Comparator<String> compartor) {
        return BinaryOperator.minBy(compartor).apply(a, b);
    }

    public int operate (int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }
}
