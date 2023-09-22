package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.rack.RequestRackDto;
import com.library.librarymanagement.dtos.rack.ResponseRackDto;

import java.util.List;

public interface RackService {
    ResponseRackDto saveRack(RequestRackDto requestRackDto);

    List<ResponseRackDto> getAll();
}
