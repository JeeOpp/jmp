package com.epam.stream1.task5.logic;

import com.epam.stream1.task4.entity.Author;
import com.epam.stream1.task4.entity.Book;
import com.epam.stream1.task4.entity.Library;
import com.epam.stream1.task5.collector.CustomCollector;

import java.util.Arrays;
import java.util.Collection;

public class Logic {
    public static void main(String[] args) {
        Library library = new Library();

        Book[] books = library.getBooks();


        //returns ordered distinct names of authors in one string line

        System.out.println(
                Arrays.stream(books)
                        .parallel()
                        .map(Book::getAuthors)
                        .flatMap(Collection::stream)
                        .map(Author::getName)
                        .distinct()
                        .collect(new CustomCollector<>())
        );
    }
}
