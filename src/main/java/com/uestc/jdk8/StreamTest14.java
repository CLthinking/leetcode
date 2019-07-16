package com.uestc.jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamTest14 {
    static class Student {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("zhangsan",20), new Student("lisi",10),
                new Student("wangwu", 90), new Student("zhaoliu", 40));
        list.stream().mapToInt(Student::getScore).max().ifPresent(System.out::println);
        list.stream().max(Comparator.comparingInt(Student::getScore)).ifPresent(System.out::println);
        list.stream().max(Comparator.comparing(Student::getScore)).ifPresent(System.out::println);
        list.stream().min(Comparator.comparing(Student::getScore)).ifPresent(System.out::println);
    }
}
