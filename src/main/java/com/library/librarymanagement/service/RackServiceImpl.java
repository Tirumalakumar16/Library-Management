package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.book.RequestBookDto;
import com.library.librarymanagement.dtos.book.ResponseBookDto;
import com.library.librarymanagement.dtos.rack.RequestRackDto;
import com.library.librarymanagement.dtos.rack.ResponseRackDto;
import com.library.librarymanagement.dtos.section.ResponseSectionDto;
import com.library.librarymanagement.models.Book;
import com.library.librarymanagement.models.Rack;
import com.library.librarymanagement.models.Section;
import com.library.librarymanagement.reposotory.BookRepository;
import com.library.librarymanagement.reposotory.RackRepository;
import com.library.librarymanagement.reposotory.SectionRepository;
import com.library.librarymanagement.service.section.SectionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RackServiceImpl implements RackService {

    private RackRepository rackRepository;

    private ModelMapper modelMapper;

    private SectionRepository sectionRepository;

    private BookRepository bookRepository;

    public RackServiceImpl(RackRepository rackRepository, ModelMapper modelMapper,
                           SectionRepository sectionRepository,
                           BookRepository bookRepository) {
        this.rackRepository = rackRepository;
        this.modelMapper = modelMapper;
        this.sectionRepository = sectionRepository;
        this.bookRepository = bookRepository;
    }

    //    @Override
//    public ResponseRackDto saveRack(RequestRackDto requestRackDto) {
//        Rack rack = new Rack();
//        rack.setRackNumber(requestRackDto.getRackNumber());
//
//        List<Book> books = new ArrayList<>();
//        for(RequestBookDto requestBookDto: requestRackDto.getBook()) {
//            Book book = new Book();
//            book.setPages(requestBookDto.getPages());
//            book.setCharges(requestBookDto.getCharges());
//            book.setBookName(requestBookDto.getBookName());
//            book.setAuthorName(requestBookDto.getAuthorName());
//            book.setPublisherName(requestBookDto.getPublisherName());
//            book.setAvailableBooks(requestBookDto.getAvailableBooks());
//            books.add(book);
//        }
//
//        rack.setBook(books);
//
//        Optional<Section> section = sectionRepository.findById(requestRackDto.getSection());
//
//        rack.setSection(section.get());
//
//        Rack rack1 = rackRepository.save(rack);
//
//        List<ResponseBookDto> responseBookDtos = mapToBooks(rack1.getBook());
//
//        ResponseRackDto responseRackDto = new ResponseRackDto();
//        responseRackDto.setBook(responseBookDtos);
//        responseRackDto.setRackNumber(rack1.getRackNumber());
//
//        ResponseSectionDto responseSectionDto = new ResponseSectionDto();
//        responseSectionDto.setSectionName(section.get().getSectionName());
//
//        responseRackDto.setSection(responseSectionDto);
//
//        return responseRackDto;
//
//    }

    @Override
    public ResponseRackDto saveRack(RequestRackDto requestRackDto) {
        Rack rack = new Rack();
        rack.setRackNumber(requestRackDto.getRackNumber());
        Optional<Section> section = sectionRepository.findById(requestRackDto.getSection());

        rack.setSection(section.get());

        Rack rack1 = rackRepository.save(rack);

        ResponseSectionDto responseSectionDto = new ResponseSectionDto();
      //  responseSectionDto.setSectionName(section.get().getSectionName());

        ResponseRackDto responseRackDto = new ResponseRackDto();
        responseRackDto.setRackNumber(rack.getRackNumber());
        responseRackDto.setSection(section.get().getSectionName());

        return responseRackDto;

    }

    private List<ResponseBookDto> mapToBooks(List<Book> book) {

        List<ResponseBookDto> responseBookDtos = new ArrayList<>();
        for(Book book1: book) {
            ResponseBookDto responseBookDto = new ResponseBookDto();
            responseBookDto.setBookName(book1.getBookName());
            responseBookDto.setAvailableBooks(book1.getAvailableBooks());
            responseBookDto.setPages(book1.getPages());
            responseBookDto.setCharges(book1.getCharges());
            responseBookDto.setPublisherName(book1.getPublisherName());
            responseBookDto.setAuthorName(book1.getAuthorName());
            responseBookDtos.add(responseBookDto);
        }
        return responseBookDtos;
    }

    @Override
    public List<ResponseRackDto> getAll() {
         List<Rack> racks = rackRepository.findAll();

         List<ResponseRackDto> responseRackDtos = new ArrayList<>();

         for (Rack rack: racks) {

             ResponseRackDto responseRackDto = new ResponseRackDto();
             responseRackDto.setRackNumber(rack.getRackNumber());
//             ResponseSectionDto responseSectionDto = new ResponseSectionDto();
//             responseSectionDto.setSectionName(rack.getSection().getSectionName());
            responseRackDto.setSection(rack.getSection().getSectionName());

             List<Book> books = bookRepository.findByRackId(rack.getId());
             List<ResponseBookDto> responseBookDtos = Arrays.asList(modelMapper.map(books, ResponseBookDto[].class));
             responseRackDto.setBooks(responseBookDtos);
             responseRackDtos.add(responseRackDto);

         }

         return  responseRackDtos;
    }
}
