package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.book.RequestBookDto;
import com.library.librarymanagement.dtos.book.ResponseBookDto;
import com.library.librarymanagement.exceptions.RackIsNotPresent;
import com.library.librarymanagement.models.Book;
import com.library.librarymanagement.models.Rack;
import com.library.librarymanagement.reposotory.BookRepository;
import com.library.librarymanagement.reposotory.RackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    private ModelMapper modelMapper;

    private RackRepository rackRepository;

    public BookServiceImpl(BookRepository bookRepository,
                           ModelMapper modelMapper, RackRepository rackRepository) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.rackRepository = rackRepository;
    }

    @Override
    public List<ResponseBookDto> saveBook(RequestBookDto requestBookDto) throws RackIsNotPresent {


        List<Book> updatedBooks = new ArrayList<>();
        for(Book book1 : requestBookDto.getBooks()) {
            Optional<Rack> rack = rackRepository.findById(requestBookDto.getRackId());
            if(rack.isEmpty()) {
                throw new RackIsNotPresent("the selected Rack is not present please add the rack..");
            }
            book1.setRack(rack.get());
            updatedBooks.add(book1);
        }

            List<Book> books=bookRepository.saveAll(updatedBooks);


        List<ResponseBookDto> responseBookDto = Arrays.asList(modelMapper.map(books, ResponseBookDto[].class));

        return responseBookDto;
    }

    @Override
    public List<ResponseBookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        List<ResponseBookDto> responseBookDtos = Arrays.asList(modelMapper.map(books, ResponseBookDto[].class));
        return responseBookDtos;
    }
}
