package com.library.librarymanagement.dtos.section;

import com.library.librarymanagement.dtos.rack.ResponseRackDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseSectionDto {

    private String libraryName;
   // private String sectionName;

    private List<ResponseRackDto> sections;
}
