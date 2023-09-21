package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.book.RequestBookDto;
import com.library.librarymanagement.dtos.book.ResponseBookDto;
import com.library.librarymanagement.models.Book;
import com.library.librarymanagement.reposotory.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    private ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseBookDto saveBook(RequestBookDto requestBookDto) {
        Book book = new Book();
        book.setBookName(requestBookDto.getBookName());
        book.setAvailableBooks(requestBookDto.getAvailableBooks());
        book.setCharges(requestBookDto.getCharges());
        book.setPages(requestBookDto.getPages());
        book.setAuthorName(requestBookDto.getAuthorName());
        book.setPublisherName(requestBookDto.getPublisherName());

        bookRepository.save(book);

        bookRepository.updateRackId(requestBookDto.getRackId(), requestBookDto.getBookName());

        Book book2 =bookRepository.findByBookName(requestBookDto.getBookName());

        ResponseBookDto responseBookDto = modelMapper.map(book2, ResponseBookDto.class);

        return responseBookDto;
    }

    @Override
    public List<ResponseBookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        List<ResponseBookDto> responseBookDtos = Arrays.asList(modelMapper.map(books, ResponseBookDto[].class));
        return responseBookDtos;
    }
}
