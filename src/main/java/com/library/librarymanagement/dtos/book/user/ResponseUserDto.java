package com.library.librarymanagement.dtos.book.user;

import com.library.librarymanagement.models.BooksBought;
import com.library.librarymanagement.models.BooksReturned;
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
public class ResponseUserDto {
    private String name;
    private String mobile;
    private String emailId;
    private int noOfBooksTaken;
    private Date createdOn;

    private List<BooksBought> booksBought;
    private List<BooksReturned> booksReturned;
}
