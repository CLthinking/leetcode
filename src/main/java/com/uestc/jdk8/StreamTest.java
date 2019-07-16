package com.uestc.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "hello world");

        String[] arr = new String[]{"hello", "world", "hello world"};
        stream = Arrays.stream(arr);

        List<String> list = Arrays.asList(arr);
        stream = list.stream();
    }

}
