package com.epam.stream1.task5.collector;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

public class CustomCollector<T> implements Collector<T,StringBuilder,List<String>> {
    @Override
    public Supplier<StringBuilder> supplier() {
        return StringBuilder::new;
    }

    @Override
    public BiConsumer<StringBuilder, T> accumulator() { //how to inject in second param
        return StringBuilder::append;
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() { //how to unite two accumulations
        return (first, second) -> first.append(" ").append(second);
    }

    @Override
    public Function<StringBuilder, List<String>> finisher() { //accumulator to result
        return (i) -> {
            List<String> list = Arrays.asList(i.toString().split(" "));
            Collections.sort(list);
            return list;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.singleton(Characteristics.CONCURRENT);
    }
}
