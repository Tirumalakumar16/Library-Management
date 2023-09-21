package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.book.booksbought.RequestBoughtDto;
import com.library.librarymanagement.dtos.book.user.RequestUserDto;
import com.library.librarymanagement.dtos.book.user.ResponseUserDto;

public interface BookBoughtService {
    String save(RequestBoughtDto requestBoughtDto);
}
