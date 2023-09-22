package com.library.librarymanagement.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestUserDto {
    private String name;
    private String mobile;
    private String emailId;
    private int noOfBooksTaken;
    private Date createdOn;
}
