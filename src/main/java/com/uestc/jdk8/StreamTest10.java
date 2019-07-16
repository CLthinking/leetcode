package com.uestc.jdk8;

import java.util.Arrays;
import java.util.List;

public class StreamTest10 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
//        list.stream().filter(s -> s.length() == 5).findFirst().ifPresent(s -> System.out.println(s + " 5"));

//        list.stream().mapToInt(String::length).filter(length -> length == 5).findFirst().ifPresent(System.out::println);

        list.stream().mapToInt(item -> {
            int len = item.length();
            System.out.println(item);
            return len;
        }).filter(len -> len == 5).findFirst().ifPresent(System.out::println);
    }
}
