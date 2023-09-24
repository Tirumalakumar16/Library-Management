package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.book.ResponseBookDto;
import com.library.librarymanagement.dtos.booksbought.RequestBoughtDto;
import com.library.librarymanagement.dtos.booksbought.ResponseBoughtDto;
import com.library.librarymanagement.dtos.user.ResponseUserDto;
import com.library.librarymanagement.models.Book;
import com.library.librarymanagement.models.BooksBought;
import com.library.librarymanagement.models.User;
import com.library.librarymanagement.reposotory.BookRepository;
import com.library.librarymanagement.reposotory.BooksBoughtRepository;
import com.library.librarymanagement.reposotory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BooksBoughtServiceImpl implements BooksBoughtService {
    private BooksBoughtRepository booksBoughtRepository;
    private  ModelMapper modelMapper;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    @Autowired
    public BooksBoughtServiceImpl(BooksBoughtRepository booksBoughtRepository, ModelMapper modelMapper,
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
    @Override
    public List<ResponseBoughtDto> getAll() {
        List<BooksBought>  booksBoughts = booksBoughtRepository.findAll();

        List<ResponseBoughtDto> responseBoughtDtos = new ArrayList<>();

        for(BooksBought booksBought: booksBoughts) {

            ResponseBoughtDto responseBoughtDto = new ResponseBoughtDto();
            responseBoughtDto.setQuantity(booksBought.getQuantity());
            responseBoughtDto.setTakenOn(booksBought.getTakenOn());

            User user = booksBought.getUser();
            ResponseUserDto responseUserDto= modelMapper.map(user, ResponseUserDto.class);
            responseBoughtDto.setUser(responseUserDto);

            Book book = booksBought.getBook();

            ResponseBookDto responseBookDto = modelMapper.map(book, ResponseBookDto.class);

            responseBoughtDto.setBook(responseBookDto);

            responseBoughtDtos.add(responseBoughtDto);

        }

        return responseBoughtDtos;
    }
}
