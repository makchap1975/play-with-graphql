package com.makchap.graphql.dao;

import com.makchap.graphql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

    List<Book> findByPublisher(String publisher);
}
