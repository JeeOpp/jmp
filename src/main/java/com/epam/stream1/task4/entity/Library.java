package com.epam.stream1.task4.entity;

import lombok.Data;

import java.util.Arrays;
import java.util.Collections;

@Data
public class Library {
    private Book firstBook;
    private Book secondBook;
    private Book thirdBook;

    private Author firstAuthor;
    private Author secondAuthor;
    private Author thirdAuthor;

    private Author[] authors;
    private Book[] books;


    public Library() {
        firstBook = Book.builder()
                .title("firstTitle")
                .numberOfPages(101)
                .build();
        secondBook = Book.builder()
                .title("secondTitle")
                .numberOfPages(301)
                .build();
        thirdBook = Book.builder()
                .title("thirdTitle")
                .numberOfPages(401)
                .build();

        firstAuthor = Author.builder()
                .name("firstAuthor")
                .age((short) 21)
                .build();

        secondAuthor = Author.builder()
                .name("secondAuthor")
                .age((short) 31)
                .build();

        thirdAuthor = Author.builder()
                .name("thirdAuthor")
                .age((short) 41)
                .build();

        firstAuthor.setBooks(Arrays.asList(secondBook, thirdBook));
        secondAuthor.setBooks(Arrays.asList(firstBook, thirdBook));
        thirdAuthor.setBooks(Arrays.asList(secondBook, firstBook));

        firstBook.setAuthors(Collections.singletonList(thirdAuthor));
        secondBook.setAuthors(Arrays.asList(firstAuthor,thirdAuthor));
        thirdBook.setAuthors(Arrays.asList(firstAuthor,secondAuthor));


        authors = (Author[]) Arrays.asList(firstAuthor,secondAuthor,thirdAuthor).toArray();
        books = (Book[]) Arrays.asList(firstBook,secondBook,thirdBook).toArray();
    }
}
