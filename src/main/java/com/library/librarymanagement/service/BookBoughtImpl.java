package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.booksbought.RequestBoughtDto;
import com.library.librarymanagement.models.Book;
import com.library.librarymanagement.models.BooksBought;
import com.library.librarymanagement.models.User;
import com.library.librarymanagement.reposotory.BookRepository;
import com.library.librarymanagement.reposotory.BooksBoughtRepository;
import com.library.librarymanagement.reposotory.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookBoughtImpl implements BookBoughtService{

    private BooksBoughtRepository booksBoughtRepository;
    private ModelMapper modelMapper;
    private BookRepository bookRepository;

    private UserRepository userRepository;

    public BookBoughtImpl(BooksBoughtRepository booksBoughtRepository, ModelMapper modelMapper,
                          BookRepository bookRepository, UserRepository userRepository) {
        this.booksBoughtRepository = booksBoughtRepository;
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String save(RequestBoughtDto requestBoughtDto) {

        Book book = bookRepository.findByBookName(requestBoughtDto.getBookName());

        int quantityAvailable = book.getAvailableBooks();
        quantityAvailable = quantityAvailable - requestBoughtDto.getQuantity();
        bookRepository.updateBookByAvailableBooks(quantityAvailable, requestBoughtDto.getBookName());

        User user = userRepository.findByEmailId(requestBoughtDto.getEmailId());

        int bookQuantity = requestBoughtDto.getQuantity();
        bookQuantity = bookQuantity+user.getNoOfBooksTaken();

        userRepository.updateUserByNoOfBooksTaken(bookQuantity, requestBoughtDto.getEmailId());

        BooksBought booksBought = new BooksBought();

        booksBought.setBook(book);
        booksBought.setUser(user);
        booksBought.setQuantity(requestBoughtDto.getQuantity());
        booksBought.setTakenOn(new Date());

        BooksBought booksBought1 = booksBoughtRepository.save(booksBought);

       return "book purchased successfully...";

    }
}
