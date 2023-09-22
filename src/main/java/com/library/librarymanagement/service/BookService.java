package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.book.RequestBookDto;
import com.library.librarymanagement.dtos.book.ResponseBookDto;
import com.library.librarymanagement.exceptions.RackIsNotPresent;

import java.util.List;

public interface BookService {
    List<ResponseBookDto> saveBook(RequestBookDto requestBookDto) throws RackIsNotPresent;

    List<ResponseBookDto> findAll();
}
