package com.augeregalloydelisle.back.service;

import java.util.Optional;

import com.augeregalloydelisle.back.entity.User;
import com.augeregalloydelisle.back.exception.ForbiddenException;
import com.augeregalloydelisle.back.exception.RessourceNotFoundException;
import com.augeregalloydelisle.back.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(String userName, String password) {
        User user = new User(userName, password);
        return userRepository.save(user);
    }

    public User login(String userName, String password) throws RessourceNotFoundException, ForbiddenException {
        Optional<User> user = userRepository.findByUsername(userName);
        if (user.isEmpty()) {
            throw new RessourceNotFoundException("User Not Found with UserName =" + userName);
        }
        User u = user.get();
        if (u.getPassword().equals(password)) {
            return u;
        } else {
            throw new ForbiddenException("UserName or Password are incorrect");
        }
    }

    public User findByUserName(String userName) {
        Optional<User> user = userRepository.findByUsername(userName);
        if (user.isEmpty()) {
            throw new RessourceNotFoundException("User Not Found with UserName =" + userName);
        }
        return user.get();
    }

}
