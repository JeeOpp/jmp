package com.epam.stream1.task3;

import com.epam.stream1.task1.entity.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

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

        ThreeFunction<Person, Person, Person, List<Person>> toArrayFunction = (f, s, t) -> Arrays.asList(f, s, t);

        toArrayFunction.function(first, second, third).
                forEach(System.out::println);

        ThreeFunction<String, String, String, Integer> max = (f, s, t) -> Stream.of(f,s,t)
                .map(Integer::parseInt)
                .max(Comparator.naturalOrder())
                .orElseThrow(RuntimeException::new);

        System.out.println(max.function("1","10", "5"));

    }
}
