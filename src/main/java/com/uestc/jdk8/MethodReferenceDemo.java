package com.uestc.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        Integer[] integers = new Integer[]{1,2,3,4,5};
        Arrays.stream(Integer[].class.getInterfaces()).forEach(cls -> System.out.println(cls.getName()));

        Object[] objects = (Object[])integers;
        Arrays.stream(objects).forEach(System.out::println);

        list.sort(String::compareTo);


        list.forEach(System.out::println);
    }


}
