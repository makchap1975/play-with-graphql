package com.makchap.graphql.controller;

import com.makchap.graphql.dao.BookRepository;
import com.makchap.graphql.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BookControllerTest {

    @Autowired
    private BookController bookController;

    @MockBean
    BookRepository bookRepository;


    @Test
    void books() {
        //Mockito.when(bookRepository.findAll()).thenReturn(List.of(new Book()));
        Iterable<Book> books = bookController.books();
        assertNotNull(books);
    }
}
