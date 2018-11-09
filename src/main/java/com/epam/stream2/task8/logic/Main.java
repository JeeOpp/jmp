package com.epam.stream2.task8.logic;

import com.epam.stream2.task8.collector.TreeCollector;
import com.epam.stream2.task8.entity.Tree;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Tree firstFirst = new Tree(11);
        Tree firstSecond = new Tree(12);
        Tree first = new Tree(1, firstFirst, firstSecond);

        Tree secondFirst = new Tree(21);
        Tree secondSecond = new Tree(22);
        Tree second = new Tree(2, secondFirst, secondSecond);

        Tree root = new Tree(0, first, second);

        root.getAllValues().forEach(System.out::print);
        root.getEvenValues().forEach(System.out::println);
        System.out.println(root.sumOfEvenValues());
        System.out.println(root.isContains13());
    }
}
