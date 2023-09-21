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
public class Rack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rackNumber;
    @OneToMany(mappedBy = "rack",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Book> book;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Section section;
}
