package com.uestc.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {
    public static void main(String[] args) {

        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);

        List<Person> persons = Arrays.asList(person1, person2, person3);

        PersonTest test = new PersonTest();
        List<Person> personResult = test.getPersonByUsername("zhangsan", persons);
        personResult.forEach(person -> System.out.println(person.getUsername()));

        List<Person> personList = test.getPersonByAge(20, persons,
                (age, ps) -> ps.stream().filter(p -> p.getAge() <= age).collect(Collectors.toList()));
        personList.forEach(p -> System.out.println(p.getAge()));

    }

    public List<Person> getPersonByUsername(String username, List<Person> persons) {
        return persons.stream().filter(p -> p.getUsername().equals(username)).collect(Collectors.toList());
    }

    public List<Person> getPersonByAge(int age, List<Person> personList,
                                       BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, personList);
    }

}
