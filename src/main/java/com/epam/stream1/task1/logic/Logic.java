package com.epam.stream1.task1.logic;

import com.epam.stream1.task1.comparator.NameComparator;
import com.epam.stream1.task1.entity.Person;
import com.epam.stream1.task1.comparator.AgeComparator;

import java.util.Arrays;
import java.util.List;

public class Logic {

    public static void main(String[] args) {
        Person first = Person.builder()
                .age(25)
                .name("Andrei")
                .build();
        Person second = Person.builder()
                .age(16)
                .name("Dzmitry")
                .build();
        Person third = Person.builder()
                .age(20)
                .name("Ilya")
                .build();

        List<Person> persons = Arrays.asList(first,second,third);

        persons.stream()
                .sorted(new AgeComparator())
                .peek(System.out::println)
                .sorted(new NameComparator())
                .forEach(System.out::println);

    }
}
