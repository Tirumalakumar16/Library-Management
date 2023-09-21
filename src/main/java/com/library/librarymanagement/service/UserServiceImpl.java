package com.library.librarymanagement.service;

import com.library.librarymanagement.dtos.book.user.RequestUserDto;
import com.library.librarymanagement.dtos.book.user.ResponseUserDto;
import com.library.librarymanagement.models.User;
import com.library.librarymanagement.reposotory.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseUserDto save(RequestUserDto requestUserDto) {
        User user = new User();
        user.setMobile(requestUserDto.getMobile());
        user.setName(requestUserDto.getName());
        user.setEmailId(requestUserDto.getEmailId());
        user.setCreatedOn(new Date());
        user.setNoOfBooksTaken(0);

        User user1 = userRepository.save(user);
        ResponseUserDto responseUserDto = modelMapper.map(user1, ResponseUserDto.class);

        return responseUserDto;

    }
}
