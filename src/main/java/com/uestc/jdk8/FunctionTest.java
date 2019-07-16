package com.uestc.jdk8;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        System.out.println(test.compute(1, Function.identity()));
        System.out.println(test.compute(1, value -> 2 * value));
        Function<Integer, Integer> function = value -> value * 2;
        System.out.println(test.compute(2, function.compose(val -> 1 + val)));

        System.out.println(test.compute(2, value -> 5 + value));
        System.out.println(test.compute(3, value -> value * value));

        System.out.println(test.convert(5, value -> value + "hello"));
    }

    public int compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

}
