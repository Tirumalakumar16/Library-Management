package com.library.librarymanagement.controller;

import com.library.librarymanagement.dtos.book.RequestBookDto;
import com.library.librarymanagement.dtos.book.ResponseBookDto;
import com.library.librarymanagement.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/book")
    public ResponseBookDto saveBook(@RequestBody RequestBookDto requestBookDto) {

        return bookService.saveBook(requestBookDto);
    }
    @GetMapping("/books")
    public List<ResponseBookDto> getAllBooks() {
        List<ResponseBookDto> responseBookDtos = bookService.findAll();

        return responseBookDtos;
    }

}
