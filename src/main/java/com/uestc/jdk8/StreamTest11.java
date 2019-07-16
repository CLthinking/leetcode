package com.uestc.jdk8;

import java.util.Arrays;
import java.util.List;

public class StreamTest11 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");
        list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
    }
}
