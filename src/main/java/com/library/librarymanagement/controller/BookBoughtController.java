package com.library.librarymanagement.controller;

import com.library.librarymanagement.dtos.booksbought.RequestBoughtDto;
import com.library.librarymanagement.service.BookBoughtService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookBoughtController {

    private BookBoughtService bookBoughtService;

    public BookBoughtController(BookBoughtService bookBoughtService) {
        this.bookBoughtService = bookBoughtService;
    }
    @PostMapping("/purchase")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    private String purchase(@RequestBody RequestBoughtDto requestBoughtDto) {

        return bookBoughtService.save(requestBoughtDto);
    }


}
