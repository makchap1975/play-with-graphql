package com.makchap.graphql.dao;

import com.makchap.graphql.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByName(String name);

}
