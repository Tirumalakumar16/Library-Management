package com.library.librarymanagement.controller;

import com.library.librarymanagement.dtos.section.RequestSectionDto;
import com.library.librarymanagement.dtos.section.ResponseSectionDto;
import com.library.librarymanagement.service.section.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SectionController {

        private SectionService sectionService;
    @Autowired
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }
    @PostMapping("/section")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseSectionDto saveSection(@RequestBody RequestSectionDto sectionDto) {

        return sectionService.saveSection(sectionDto);
    }

    @GetMapping("/sections")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseSectionDto getAllSections() {
        return sectionService.getAll();
    }
}
