package com.library.librarymanagement.dtos.book.booksbought;

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
    private Book book;
    private Date takenOn;
    private int quantity;
    private User user;
}
