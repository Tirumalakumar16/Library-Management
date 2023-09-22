package com.library.librarymanagement.service.section;

import com.library.librarymanagement.dtos.rack.ResponseRackDto;
import com.library.librarymanagement.dtos.section.RequestSectionDto;
import com.library.librarymanagement.dtos.section.ResponseSectionDto;
import com.library.librarymanagement.models.Library;
import com.library.librarymanagement.models.Rack;
import com.library.librarymanagement.models.Section;
import com.library.librarymanagement.reposotory.LibraryRepository;
import com.library.librarymanagement.reposotory.SectionRepository;
import com.library.librarymanagement.service.RackServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SectionServiceImpl implements SectionService{

    private SectionRepository sectionRepository;

    private ModelMapper modelMapper;

    private LibraryRepository libraryRepository;

    private RackServiceImpl rackService;

    public SectionServiceImpl(SectionRepository sectionRepository,
                              ModelMapper modelMapper, LibraryRepository libraryRepository, RackServiceImpl rackService) {
        this.sectionRepository = sectionRepository;
        this.modelMapper = modelMapper;
        this.libraryRepository = libraryRepository;
        this.rackService = rackService;
    }

    @Override
    public ResponseSectionDto saveSection(RequestSectionDto sectionDto) {
        Section section = new Section();
        section.setSectionName(sectionDto.getSectionName());

        Optional<Library> library = libraryRepository.findById(sectionDto.getLibraryId());

        ResponseSectionDto responseSectionDto = new ResponseSectionDto();
        responseSectionDto.setLibraryName(library.get().getLibraryName());
        //List<ResponseRackDto> responseRackDtos = rackService.getAll();
       // responseSectionDto.setRacks(responseRackDtos);
     //   responseSectionDto.setSectionName(section.getSectionName());

        return responseSectionDto;

    }

    @Override
    public ResponseSectionDto getAll() {
          List<Section> sections =sectionRepository.findAll();



          List<ResponseRackDto> responseRackDtos =rackService.getAll();

          Optional<Library> library = libraryRepository.findById(sections.get(0).getLibrary().getId());

          ResponseSectionDto responseSectionDto = new ResponseSectionDto();
          responseSectionDto.setSections(responseRackDtos);
          responseSectionDto.setLibraryName(library.get().getLibraryName());


          return responseSectionDto;
    }
}
