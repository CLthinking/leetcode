package com.uestc.jdk8;

import java.util.Arrays;
import java.util.List;

public class StreamTest3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        System.out.println(list.stream().mapToInt(i -> 2 * i).sum());
        list.stream().map(i -> i * 2).reduce(Math::min).ifPresent(System.out::println);
    }
}
