package com.epam.stream1.task4.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString(exclude = "books")
@EqualsAndHashCode(exclude = "books")
public class Author {
    private String name;
    private short age;
    private List<Book> books;
}
