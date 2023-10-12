package com.library.librarymanagement.controller;

import com.library.librarymanagement.dtos.book.RequestBookDto;
import com.library.librarymanagement.dtos.book.ResponseBookDto;
import com.library.librarymanagement.exceptions.RackIsNotPresent;
import com.library.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/book")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<ResponseBookDto> saveBook(@RequestBody RequestBookDto requestBookDto) {
        List<ResponseBookDto> responseBookDtos = null;
        try {
             responseBookDtos = bookService.saveBook(requestBookDto);
             return responseBookDtos;
        } catch (RackIsNotPresent e) {
            System.out.println(e.getMessage());
        }
        return responseBookDtos;
    }
    @GetMapping("/books")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAnyAuthority('ROLE_USER')")
    public List<ResponseBookDto> getAllBooks() {
        List<ResponseBookDto> responseBookDtos = bookService.findAll();

        return responseBookDtos;
    }

}
