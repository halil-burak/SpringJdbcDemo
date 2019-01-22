package com.hburak.manytomany.demo1.utility;

import com.hburak.manytomany.demo1.entity.Author;
import com.hburak.manytomany.demo1.entity.Book;
import com.hburak.manytomany.demo1.repository.AuthorRepository;
import com.hburak.manytomany.demo1.repository.BookRepository;
import com.sun.jmx.snmp.internal.SnmpSubSystem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan("com.hburak.manytomany.demo1")
public class JdbcTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public AuthorRepository getAuthorRepository() {
        return authorRepository;
    }

    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Test
    public void testRelationships() {
        Author author = new Author();
        author.setName("Martin Fowler");
        Author author2 = new Author();
        author2.setName("John Doe");
        Author author3 = new Author();
        author3.setName("Vlad Putin");

        authorRepository.save(author);
        authorRepository.save(author2);
        authorRepository.save(author3);

        Book book = new Book();
        book.setTitle("Refactoring");
        book.setIsbn("asd123");
        book.addAuthor(author);

        Book book2 = new Book();
        book2.setTitle("Clean Code");
        book2.setIsbn("123asd");
        book2.addAuthor(author2);

        bookRepository.save(book);
        bookRepository.save(book2);

        for (Book b : bookRepository.findAll()) {
            System.out.println(authorRepository.findAllById(b.getAuthorIds()));
            for (Long l : b.getAuthorIds()) {
                System.out.println("author id: " + authorRepository.findById(l).get().getId());
            }
            System.out.println(b.getAuthorIds());
            System.out.println(b.getAuthorNames());
        }

        /**
         * fetch all the authors from authorRepository
         * but author does not really have a reference to books
         * so instead we need to make another method in bookRepository
         * method name be like findByAuthorId, where we pass an author
         */
        for (Author a : authorRepository.findAll()) {
            System.out.println("book: " + bookRepository.findByAuthorId(a.getId()));
            System.out.println("book: " + bookRepository.findByAuthorName(a.getName()));
        }

        for (Author a2 : authorRepository.findAuthorsWithBooks()) {
            System.out.println("bookk: " + bookRepository.findByAuthorId(a2.getId()));
            System.out.println("bookk: " + bookRepository.findByAuthorName(a2.getName()));
        }
    }
}
