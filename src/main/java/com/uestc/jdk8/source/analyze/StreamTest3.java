package com.uestc.jdk8.source.analyze;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class StreamTest3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().forEach(System.out::println);

        Consumer<Integer> consumer = System.out::println;
        IntConsumer intConsumer= (IntConsumer) consumer;
        IntConsumer intConsumer1 = System.out::println;
    }
}
