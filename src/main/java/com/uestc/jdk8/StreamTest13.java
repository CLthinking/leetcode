package com.uestc.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Man {
    private String name;
    private int score;
    private int age;

    public Man(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class StreamTest13 {

    public static void main(String[] args) {
        Man man1 = new Man("zhangsan", 100, 20);
        Man man2 = new Man("lisi", 90, 20);
        Man man3 = new Man("wangwu", 90, 30);
        Man man4 = new Man("zhangsan", 80, 40);

        List<Man> list = Arrays.asList(man1, man2, man3, man4);

//        Map<String, List<Man>> map = list.stream().collect(Collectors.groupingBy(Man::getName));
//        Map<Integer, List<Man>> map =  list.stream().collect(Collectors.groupingBy(Man::getAge));

//        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Man::getName, Collectors.counting()));

//        Map<String, Double> map = list.stream().collect(Collectors.groupingBy(Man::getName, Collectors.averagingDouble(Man::getScore)));

        Map<Boolean, List<Man>> map = list.stream().collect(Collectors.partitioningBy(man -> man.getScore() >= 90));

        System.out.println(map);




    }
}
