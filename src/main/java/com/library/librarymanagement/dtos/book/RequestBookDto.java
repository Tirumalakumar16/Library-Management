package com.library.librarymanagement.dtos.book;

import com.library.librarymanagement.models.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestBookDto {
   private List<Book> books;
   private Long rackId;
}
