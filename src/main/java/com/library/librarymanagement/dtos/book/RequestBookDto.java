package com.library.librarymanagement.dtos.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestBookDto {
    private String bookName;
    private int availableBooks;
    private String authorName;
    private String publisherName;
    private double charges;
    private int pages;
    private int rackId;
}
