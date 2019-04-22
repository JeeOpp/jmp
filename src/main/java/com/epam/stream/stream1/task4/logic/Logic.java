package com.epam.stream.stream1.task4.logic;

import com.epam.stream.stream1.task4.entity.Book;
import com.epam.stream.stream1.task4.entity.Library;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Logic {
    public static void main(String[] args) {
        Library library = new Library();

        Book[] books = library.getBooks();

        //1
        System.out.println(
                Arrays.stream(books)
                        .anyMatch((item) -> item.getNumberOfPages() > 200)
        );

        //2
        System.out.println(
                Arrays.stream(books)
                        .map(Book::getNumberOfPages)
                        .max(Comparator.naturalOrder())
                        .orElseThrow(RuntimeException::new)
        );

        //3
        final int oneAuthor = 1;
        Arrays.stream(books)
                .filter((i) -> i.getAuthors().size() == oneAuthor)
                .forEach(System.out::println);

        //4
        Arrays.stream(books)
                .sorted(Comparator.comparingInt(Book::getNumberOfPages))
                .forEach(System.out::println);

        //5
        System.out.println(
                Arrays.stream(books)
                        .map(Book::getTitle)
                        .distinct()
                        .collect(Collectors.toList())
        );

        //6 similar with 4
        //7
        Arrays.stream(books)
                .map(Book::getAuthors)
                .flatMap(Collection::stream)
                .distinct()
                .forEach(System.out::println);
        //peek - no comments
    }
}
