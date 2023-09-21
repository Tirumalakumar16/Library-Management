package com.library.librarymanagement.controller;

import com.library.librarymanagement.dtos.book.user.RequestUserDto;
import com.library.librarymanagement.dtos.book.user.ResponseUserDto;
import com.library.librarymanagement.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
