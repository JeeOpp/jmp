package com.epam.stream.stream1.task3;

@FunctionalInterface
public interface ThreeFunction<F,S,T,R> {
    R function(F first, S second, T third);
}
