package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.booksbought.RequestBoughtDto;
import com.library.librarymanagement.dtos.booksbought.ResponseBoughtDto;


import java.util.List;

public interface BooksBoughtService {
    String save(RequestBoughtDto requestBoughtDto);

    List<ResponseBoughtDto> getAll();
}
