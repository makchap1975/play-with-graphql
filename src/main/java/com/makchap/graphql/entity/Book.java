package com.makchap.graphql.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String publisher;
    private LocalDate publishedDate;
    private String genre;

    @ToString.Exclude
    @ManyToOne()
    @JoinColumn
    private Author author;

}
