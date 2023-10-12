package com.library.librarymanagement.controller;

import com.library.librarymanagement.dtos.booksbought.RequestBoughtDto;
import com.library.librarymanagement.dtos.booksbought.ResponseBoughtDto;
import com.library.librarymanagement.service.BooksBoughtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksBController {
    private final BooksBoughtService booksBoughtService;
    @Autowired
    public BooksBController(BooksBoughtService booksBoughtService) {
        this.booksBoughtService = booksBoughtService;
    }


    @PostMapping("/purchase")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    private String purchase(@RequestBody RequestBoughtDto requestBoughtDto) {


        return booksBoughtService.save(requestBoughtDto);
    }
    @GetMapping("/purchases")
    public List<ResponseBoughtDto> getAllBooksBought() {

        return booksBoughtService.getAll();
    }
}
