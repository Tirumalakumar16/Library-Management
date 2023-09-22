package com.library.librarymanagement.controller;

import com.library.librarymanagement.dtos.book.RequestBookDto;
import com.library.librarymanagement.dtos.book.ResponseBookDto;
import com.library.librarymanagement.exceptions.RackIsNotPresent;
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
    public List<ResponseBookDto> getAllBooks() {
        List<ResponseBookDto> responseBookDtos = bookService.findAll();

        return responseBookDtos;
    }

}
