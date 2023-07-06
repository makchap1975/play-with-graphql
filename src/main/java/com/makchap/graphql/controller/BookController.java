package com.makchap.graphql.controller;

import com.makchap.graphql.dao.BookRepository;
import com.makchap.graphql.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepository;

    @QueryMapping
    public Iterable<Book> books() {
        logger.debug("inside ....books findAll");
        return bookRepository.findAll();
    }

    @QueryMapping
    public Optional<Book> bookById(@Argument Long id) {
        logger.debug("Inside........bookById: {}", id);
        return bookRepository.findById(id);
    }

    @QueryMapping
    public List<Book> bookByTitle(@Argument String title) {
        logger.debug("Inside........bookByTitle");
        return bookRepository.findByTitle(title);
    }

    @QueryMapping
    public List<Book> bookByPublisher(@Argument String publisher) {
        logger.debug("Inside........bookByPublisher");
        return bookRepository.findByPublisher(publisher);
    }

}
