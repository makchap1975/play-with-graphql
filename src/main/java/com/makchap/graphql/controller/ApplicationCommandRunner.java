package com.makchap.graphql.controller;

import com.makchap.graphql.dao.AuthorRepository;
import com.makchap.graphql.dao.BookRepository;
import com.makchap.graphql.entity.Author;
import com.makchap.graphql.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ApplicationCommandRunner implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info(" ApplicationRunner called");
        Author author1 = Author.builder().name("Jay Weather").build();
        Author author2 = Author.builder().name("Tim Lewis").build();
        Author author3 = Author.builder().name("Ken Blanchard").build();
        authorRepository.saveAll(List.of(author1, author2, author3));

        logger.info("# of Authors: {}", authorRepository.count());

        Book book1 =
                Book.builder().title("Java Cookbook").author(author1).genre("Programming").publishedDate(LocalDate.of(2011, 03, 01)).build();
        Book book2 =
                Book.builder().title("GraphQL Reference Guide").author(author2).genre("Programming").publisher("Abe Books").publishedDate(LocalDate.of(2018, 03, 15)).build();
        Book book3 =
                Book.builder().title("The 1 Minute Manager").author(author3).publisher("William " +
                        " Morrow Books").genre("Business").publishedDate(LocalDate.of(1982, 02, 01)).build();
        bookRepository.saveAll(List.of(book1, book2, book3));

        logger.info("# of Books: {}", bookRepository.count());
        logger.info("ApplicationRunner completed");

    }
}
