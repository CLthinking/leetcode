package com.uestc.jdk8;

import java.util.function.Supplier;

public class StudentTest {

    public static void main(String[] args) {
        Supplier<Student> supplier = Student::new;
        System.out.println(supplier.get().getName());

        System.out.println("--------------");

        Supplier<Student> supplier1 = () -> new Student();
        System.out.println(supplier1.get().getName());
    }
}
