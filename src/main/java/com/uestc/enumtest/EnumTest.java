package com.uestc.enumtest;

import java.util.Arrays;

/**
 * @author CLthinking
 * @date 2019/7/12 下午 08:48
 */
public enum EnumTest {
    SMALL(1), MEDIUM(2), LARGE(3);

    private int id;
    private EnumTest(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        EnumTest test = EnumTest.MEDIUM;
        System.out.println(test.name());
        System.out.println(test.ordinal());
        System.out.println(test.toString());
        System.out.println("============================");
        Arrays.stream(EnumTest.values()).forEach(System.out::println);
//        ThreadPoolExecutor
    }
}
