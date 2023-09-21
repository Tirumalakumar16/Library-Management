package com.library.librarymanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    private int availableBooks;
    private String authorName;
    private String publisherName;
    private double charges;
    private int pages;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Rack rack;
    @OneToOne(mappedBy = "book",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private BooksBought booksBought;
    @OneToOne(mappedBy = "book",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private BooksReturned booksReturned;
}
