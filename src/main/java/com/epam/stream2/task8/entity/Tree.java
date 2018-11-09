package com.epam.stream2.task8.entity;

import com.epam.stream2.task8.collector.TreeCollector;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tree {
    private Integer value;
    private List<Tree> children = new LinkedList<>();

    public Tree(int value, List<Tree> children) {
        super();
        this.value = value;
        this.children.addAll(children);
    }

    public Tree(int value, Tree... children) {
        this(value, Arrays.asList(children));
    }

    public Integer getValue() {
        return value;
    }

    public List<Tree> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public Stream<Tree> flattened() {
        return Stream.of(this)
                .collect(new TreeCollector());
    }

    public List<Integer> getAllValues() {
        return flattened()
                .map(Tree::getValue)
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenValues(){
        return getAllValues().stream()
                .filter((i) -> i%2 == 0)
                .collect(Collectors.toList());
    }

    public Optional<Integer> sumOfEvenValues(){
        return getEvenValues().stream()
                .reduce((f,s)-> f + s);
    }

    public Boolean isContains13(){
        return getAllValues().stream()
                .anyMatch((i)-> i == 13);
    }
}