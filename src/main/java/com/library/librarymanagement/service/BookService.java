package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.book.RequestBookDto;
import com.library.librarymanagement.dtos.book.ResponseBookDto;

import java.util.List;

public interface BookService {
    ResponseBookDto saveBook(RequestBookDto requestBookDto);

    List<ResponseBookDto> findAll();
}
