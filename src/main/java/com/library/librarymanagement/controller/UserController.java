package com.library.librarymanagement.controller;

import com.library.librarymanagement.dtos.user.RequestUserDto;
import com.library.librarymanagement.dtos.user.ResponseUserDto;
import com.library.librarymanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public ResponseUserDto saveUser(@RequestBody RequestUserDto requestUserDto) {

        return userService.save(requestUserDto);
    }
    @GetMapping("/user/books/{email}")
    public ResponseUserDto getBooksBought(@PathVariable("email") String email) {

        return userService.getAllBooksBought(email);
    }
}
