package com.hburak.manytomany.demo1.entity;

import org.springframework.data.relational.core.mapping.Table;

@Table(value = "book_author")
public class AuthorRef {
    private Long author;
    private String name;

    AuthorRef(Long author, String name) {
        this.author = author;
        this.name = name;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
