package com.uestc.jdk8;

import java.util.stream.IntStream;

public class StreamTest2 {

    public static void main(String[] args) {
        IntStream.of(5, 6, 7).forEach(System.out::println);
        System.out.println("----------------");

        IntStream.range(3, 8).forEach(System.out::println);
        System.out.println("----------------");

        IntStream.rangeClosed(3, 8).forEach(System.out::println);
    }
}
