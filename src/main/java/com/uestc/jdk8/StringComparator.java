package com.uestc.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringComparator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangsan", "lisi","wangwu", "zhaoliu");
        names.sort(Comparator.reverseOrder());
        System.out.println(names);
        names.sort(Comparator.reverseOrder());
        System.out.println(names);


    }

}
