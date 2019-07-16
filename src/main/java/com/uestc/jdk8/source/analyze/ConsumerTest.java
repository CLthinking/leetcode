package com.uestc.jdk8.source.analyze;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerTest {
    public void test(Consumer<? super Integer> consumer) {
        if (consumer instanceof IntConsumer) {
            System.out.println("if");
            testInt((IntConsumer) consumer);
        } else {
            System.out.println("else");
            testInt((IntConsumer) consumer::accept);
        }
//        consumer.accept(100);
    }
    public void testInt(IntConsumer intConsumer) {
        System.out.println("in intConsumer");
    }

    public static void main(String[] args) {
        ConsumerTest consumerTest = new ConsumerTest();
        Consumer<Integer> consumer = System.out::println;
        IntConsumer intConsumer = System.out::println;

//        System.out.println(consumer instanceof Consumer);
//        System.out.println(intConsumer instanceof IntConsumer);

//        consumerTest.test(consumer);  // 面向对象方式
//        consumerTest.test(consumer::accept);  // 函数式方式
//        consumerTest.test(intConsumer::accept);  // 函数式方式

        consumerTest.test((Integer integer)-> System.out.println(integer));
    }
}
