package com.uestc.jdk8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("hello", "world", "hello world");

//        String[] stringarr = stream.toArray(String[]::new);
//        Arrays.stream(stringarr).forEach(System.out::println);

//        List<String> list = stream.collect(Collectors.toList());

//        List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
//        System.out.println(set.getClass().getName());

        String str = stream.collect(Collectors.joining());

        System.out.println(str);

    }
}
