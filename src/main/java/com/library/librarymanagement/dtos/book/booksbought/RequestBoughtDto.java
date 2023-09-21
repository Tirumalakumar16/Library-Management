package com.library.librarymanagement.dtos.book.booksbought;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestBoughtDto {
    private int quantity;
    private String bookName;
    private String emailId;
}
