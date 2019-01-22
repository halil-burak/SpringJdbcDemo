package com.hburak.manytomany.demo1.repository;

import com.hburak.manytomany.demo1.entity.Book;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b.* FROM Book b join book_author ba on ba.book = b.id WHERE ba.author = :id")
    Set<Book> findByAuthorId(@Param("id") Long id);

    @Query("SELECT b.* FROM Book b join book_author ba on ba.book = b.id WHERE ba.name = :name")
    Set<Book> findByAuthorName(@Param("name") String name);
}
