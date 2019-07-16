package com.uestc.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        PredicateTest test = new PredicateTest();
        List<Integer> odd = test.filter(list, i -> (i & 1) == 1);
        System.out.println(odd);
        List<Integer> even = test.filter(list, i -> (i & 1) == 0);
        System.out.println(even);
        Predicate<Integer> predicate;
        test.filter(list, (predicate = i -> i > 5).and(i -> (i & 1) == 0)).forEach(System.out::println);
    }

    public List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

}
