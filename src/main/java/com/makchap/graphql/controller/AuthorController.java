package com.makchap.graphql.controller;

import com.makchap.graphql.dao.AuthorRepository;
import com.makchap.graphql.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;


    @QueryMapping
    public Iterable<Author> authors() {
        return authorRepository.findAll();
    }

    @QueryMapping
    public Optional<Author> authorById(@Argument Long id) {
        return authorRepository.findById(id);
    }

    @QueryMapping
    public Iterable<Author> authorByName(@Argument String name) {
        return authorRepository.findByName(name);
    }
}
