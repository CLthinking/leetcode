package com.uestc.jdk8.source.analyze;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.*;

public class MyComparatorTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Nihao", "hello", "world", "welcome");
        list.sort(null);
        list.sort(comparingInt(String::length));
        list.sort(comparingInt(String::length).reversed());

        list.sort(comparingInt((String s) -> s.length()).reversed());

        list.sort(comparingInt(String::length).thenComparing(String::compareTo));



        list.forEach(System.out::println);
    }
}
