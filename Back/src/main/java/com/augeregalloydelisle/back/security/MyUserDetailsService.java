package com.augeregalloydelisle.back.security;

import com.augeregalloydelisle.back.entity.User;
import com.augeregalloydelisle.back.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userService.findByUserName(username);
        return MyUserDetails.getUserDetailsByUserEntity(userEntity);
    }
}