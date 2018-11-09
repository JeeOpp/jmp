package com.epam.stream2.task8.collector;

import com.epam.stream2.task8.entity.Tree;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class TreeCollector implements Collector<Tree, Stream.Builder, Stream<Tree>> {
    @Override
    public Supplier<Stream.Builder> supplier() {
        return Stream::builder;
    }

    @Override
    public BiConsumer<Stream.Builder, Tree> accumulator() { //how to inject in second param
        return this::addChildren;
    }

    @Override
    public BinaryOperator<Stream.Builder> combiner() { //how to unite two accumulations
        return Stream.Builder::add;
    }

    @Override
    public Function<Stream.Builder, Stream<Tree>> finisher() { //accumulator to result
        return Stream.Builder::build;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.singleton(Characteristics.UNORDERED);
    }

    private void addChildren(Stream.Builder<Tree> builder, Tree tree){
        if(tree.getValue() == null){
            return;
        }
        builder.add(tree);
        tree.getChildren()
                .forEach((i) -> addChildren(builder,i));
    }
}

