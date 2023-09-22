package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.book.ResponseBookDto;
import com.library.librarymanagement.dtos.booksbought.ResponseBoughtDto;
import com.library.librarymanagement.dtos.user.RequestUserDto;
import com.library.librarymanagement.dtos.user.ResponseUserDto;
import com.library.librarymanagement.models.BooksBought;
import com.library.librarymanagement.models.User;
import com.library.librarymanagement.reposotory.BooksBoughtRepository;
import com.library.librarymanagement.reposotory.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    private BooksBoughtRepository booksBoughtRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder,
                           BooksBoughtRepository booksBoughtRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.booksBoughtRepository = booksBoughtRepository;
    }

    @Override
    public ResponseUserDto save(RequestUserDto requestUserDto) {
        User user = new User();
        user.setMobile(requestUserDto.getMobile());
        user.setName(requestUserDto.getName());
        user.setEmailId(requestUserDto.getEmailId());
        user.setCreatedOn(new Date());
        user.setNoOfBooksTaken(0);
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(requestUserDto.getPassword()));
        user.setRoles(requestUserDto.getRoles());
        user.setUsername(requestUserDto.getUsername());

        User user1 = userRepository.save(user);
        ResponseUserDto responseUserDto = modelMapper.map(user1, ResponseUserDto.class);

        return responseUserDto;

    }

    @Override
    public ResponseUserDto getAllBooksBought(String email) {

        User user = userRepository.findByEmailId(email);

        ResponseUserDto responseUserDto = modelMapper.map(user, ResponseUserDto.class);

        List<BooksBought> booksBoughtList = booksBoughtRepository.findByuserId(user.getId());

        List<ResponseBoughtDto> responseBoughtDtos = Arrays.asList(modelMapper.map(booksBoughtList, ResponseBoughtDto[].class));

        responseUserDto.setBooksBought(responseBoughtDtos);

        return responseUserDto;
    }
}
