package com.uestc.jdk8;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");

        optional.ifPresent(System.out::println);
        optional = Optional.empty();
        optional.ifPresent(System.out::println);  // 推荐的Optional使用方式


    }
}
