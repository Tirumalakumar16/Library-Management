package com.library.librarymanagement.dtos.user;

import com.library.librarymanagement.dtos.booksbought.ResponseBoughtDto;
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

    private String username;
    private boolean isActive;
    private String roles;

    private List<ResponseBoughtDto> booksBought;

}
