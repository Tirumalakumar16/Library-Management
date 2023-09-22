package com.library.librarymanagement.service.section;

import com.library.librarymanagement.dtos.section.RequestSectionDto;
import com.library.librarymanagement.dtos.section.ResponseSectionDto;

import java.util.List;

public interface SectionService {
    ResponseSectionDto saveSection(RequestSectionDto sectionDto);

    ResponseSectionDto getAll();
}
