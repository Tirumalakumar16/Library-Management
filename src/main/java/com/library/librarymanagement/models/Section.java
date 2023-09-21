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
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sectionName;
    @OneToMany(mappedBy = "section",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Rack> racks;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Library library;
}
