package com.hburak.manytomany.demo1.entity;

import lombok.Data;

import org.springframework.data.annotation.Id;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Book {
    @Id
    private Long id;
    private String isbn;
    private String title;
    private Set<AuthorRef> authors = new HashSet<>();

    public void addAuthor(Author author) {
        this.authors.add(new AuthorRef(author.getId(), author.getName()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<AuthorRef> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorRef> authors) {
        this.authors = authors;
    }

    public Set<Long> getAuthorIds() {
        return this.authors.stream()
                .map(AuthorRef::getAuthor).collect(Collectors.toSet());
    }

    public Set<String> getAuthorNames() {
        return this.authors.stream()
                .map(AuthorRef::getName).collect(Collectors.toSet());
    }
}
