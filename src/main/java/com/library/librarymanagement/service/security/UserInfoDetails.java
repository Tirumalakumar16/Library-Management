package com.library.librarymanagement.service.security;

import com.library.librarymanagement.config.MyUsers;
import com.library.librarymanagement.models.User;
import com.library.librarymanagement.reposotory.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoDetails implements UserDetailsService {
        @Autowired
        private UserRepository userRepository;

  //  @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user =userRepository.findByUsername(username);
//        user.orElseThrow(() ->new UsernameNotFoundException(String.format("%s not exist",username)));
//        return user.map(MyUsers::new).get();
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =userRepository.findByUsername(username);
        user.orElseThrow(() ->new UsernameNotFoundException(String.format("%s not exist",username)));
        return user.map(MyUsers::new).get();
    }
}
