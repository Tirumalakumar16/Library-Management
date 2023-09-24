package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.user.RequestUserDto;
import com.library.librarymanagement.dtos.user.ResponseUserDto;

public interface UserService {
    ResponseUserDto save(RequestUserDto requestUserDto);

    ResponseUserDto getAllBooksBought(String userName);
}
