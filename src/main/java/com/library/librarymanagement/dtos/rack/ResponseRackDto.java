package com.library.librarymanagement.dtos.rack;

import com.library.librarymanagement.dtos.book.RequestBookDto;
import com.library.librarymanagement.dtos.book.ResponseBookDto;
import com.library.librarymanagement.dtos.section.ResponseSectionDto;
import com.library.librarymanagement.models.Book;
import com.library.librarymanagement.models.Section;
import com.library.librarymanagement.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseRackDto {
    private String section;
    private int rackNumber;

    private List<ResponseBookDto> books;


}
