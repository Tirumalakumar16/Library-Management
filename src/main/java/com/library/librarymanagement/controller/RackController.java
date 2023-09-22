package com.library.librarymanagement.controller;

import com.library.librarymanagement.dtos.rack.RequestRackDto;
import com.library.librarymanagement.dtos.rack.ResponseRackDto;
import com.library.librarymanagement.service.RackService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RackController {

    private RackService rackService;

    public RackController(RackService rackService) {
        this.rackService = rackService;
    }
    @PostMapping("/rack")
    public ResponseRackDto saveRack(@RequestBody RequestRackDto requestRackDto) {

        return rackService.saveRack(requestRackDto);
    }
    @GetMapping("/racks")
    public List<ResponseRackDto> getAllRacks() {

        return rackService.getAll();
    }


}
