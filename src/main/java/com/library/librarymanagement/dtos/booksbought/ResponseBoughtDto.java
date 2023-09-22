package com.library.librarymanagement.dtos.booksbought;

import com.library.librarymanagement.dtos.book.ResponseBookDto;
import com.library.librarymanagement.models.Book;
import com.library.librarymanagement.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseBoughtDto {
    private ResponseBookDto book;
    private Date takenOn;
    private int quantity;

}
