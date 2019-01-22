package com.hburak.manytomany.demo1.repository;

import com.hburak.manytomany.demo1.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a.* FROM Author a join book_author ba on ba.author = a.id")
    Set<Author> findAuthorsWithBooks();
}
