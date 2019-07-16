package com.uestc.jdk8;

import java.util.stream.IntStream;

public class StreamTest16 {
    public static void main(String[] args) {
        IntStream.rangeClosed(0,5)
                .mapToObj(i -> new Thread(() -> System.out.println(Thread.currentThread().getName())))
                .forEach(Thread::start);
    }
}
