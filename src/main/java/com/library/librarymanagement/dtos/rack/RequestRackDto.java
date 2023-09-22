package com.library.librarymanagement.dtos.rack;

import com.library.librarymanagement.dtos.book.RequestBookDto;
import com.library.librarymanagement.models.Book;
import com.library.librarymanagement.models.Section;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestRackDto {
    private int rackNumber;
    private Long section;


}
