package com.epam.stream.stream1.task4.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString(exclude = "authors")
public class Book {
    private String title;
    private List<Author> authors;
    private int numberOfPages;


}
