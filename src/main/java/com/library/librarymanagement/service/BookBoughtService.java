package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.booksbought.RequestBoughtDto;

public interface BookBoughtService {
    String save(RequestBoughtDto requestBoughtDto);
}
