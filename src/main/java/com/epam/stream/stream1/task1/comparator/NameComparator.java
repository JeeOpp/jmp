package com.epam.stream.stream1.task1.comparator;

import com.epam.stream.stream1.task1.entity.Person;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
