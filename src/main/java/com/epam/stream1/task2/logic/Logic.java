package com.epam.stream1.task2.logic;

import com.epam.stream1.task1.entity.Person;
import com.epam.stream1.task2.function.Splitter;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Logic {
    public static void main(String[] args) {

        Supplier<Person> supplier = Person::new; //empty person
        Consumer<Person> consumer = System.out::println;
        BiFunction<String, Integer, Person> function = Person::new;  //person with params
        Predicate<Person> isAdult = person -> person.getAge() > 21;


        Splitter lambdaSplitter = String::split;
        Splitter anonymousSplitter = new Splitter() {
            @Override
            public String[] split(String string, String delimiter) {
                return string.split(delimiter);
            }
        };

        String testString = "testing... test-string";

        System.out.println(Arrays.toString(
                lambdaSplitter.spaceSplit(testString)
        ));

        System.out.println(
                Arrays.toString(anonymousSplitter.dotSplit(testString))
        );

        System.out.println(
                Arrays.toString(anonymousSplitter.split(testString, Splitter.getRandomLetterDelimiter()))
        );
    }
}
