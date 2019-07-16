package com.uestc.jdk8;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest15 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1,2,3,4,1,2,3,1,2,3};
        Map<Integer, Long> map =  Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);
    }
}
