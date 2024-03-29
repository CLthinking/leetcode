package com.uestc.jdk8;

import java.util.stream.IntStream;

public class StreamTest8 {

    public static void main(String[] args) {
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);
        System.out.println("-------------------------");
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
