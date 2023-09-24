package com.library.librarymanagement.controller;

import com.library.librarymanagement.dtos.AuthRequest;
import com.library.librarymanagement.dtos.user.RequestUserDto;
import com.library.librarymanagement.dtos.user.ResponseUserDto;
import com.library.librarymanagement.service.UserService;
import com.library.librarymanagement.service.security.JwtService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController {
    private UserService userService;

    private JwtService jwtService;

    private AuthenticationManager authenticationManager;

    public UserController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/user/new")
    public ResponseUserDto saveUser(@RequestBody RequestUserDto requestUserDto) {

        return userService.save(requestUserDto);
    }
    @GetMapping("/user/books")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseUserDto getBooksBought(Principal principal) {
        String userName = principal.getName();
        return userService.getAllBooksBought(userName);
    }


    @PostMapping("/authentication")
    public String getToken(@RequestBody AuthRequest authRequest) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                authRequest.getPassword()));

        if(authenticate.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());

        } else  {
            throw  new UsernameNotFoundException("user is not found in data base");
        }

    }
}
