package com.epam.stream.stream1.task2.function;

import java.util.Random;

@FunctionalInterface
public interface Splitter {

    String[] split(String string, String delimiter);

    default String[] spaceSplit(String string){
        return string.split(" ");
    }

    default String[] dotSplit(String string){
        return string.split("[.]");
    }

    static String getRandomLetterDelimiter(){
        return Character.toString(
                (char)(new Random().nextInt(26) + 'a')
        );
    }
}
