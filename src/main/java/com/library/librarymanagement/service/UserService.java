package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.book.user.RequestUserDto;
import com.library.librarymanagement.dtos.book.user.ResponseUserDto;

public interface UserService {
    ResponseUserDto save(RequestUserDto requestUserDto);
}
