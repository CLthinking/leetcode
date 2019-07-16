package com.uestc.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Test3 {

    public static void main(String[] args) {
//        new Thread(() -> System.out.println("hello world")).start();
        List<String>  list = Arrays.asList("hello", "world", "hello world");
//        list.forEach(item -> System.out.println(item.toUpperCase()));
        List<String> list2 = new ArrayList<>();
//        list.forEach(item -> list2.add(item.toUpperCase()));
//        list2.forEach(System.out::println);

//        list.stream().map(String::toUpperCase).forEach(System.out::println);

        Function<String, String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);

    }

}
