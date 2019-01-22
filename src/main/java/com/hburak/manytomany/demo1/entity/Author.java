package com.hburak.manytomany.demo1.entity;

import org.springframework.data.annotation.Id;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Author {
    @Id
    private Long id;
    private String name;
    private LocalDate birthDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
