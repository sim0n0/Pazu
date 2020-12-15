package com.augeregalloydelisle.back.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.augeregalloydelisle.back.entity.User;
import com.augeregalloydelisle.back.exception.BadRequestException;
import com.augeregalloydelisle.back.exception.ForbiddenException;
import com.augeregalloydelisle.back.exception.RessourceNotFoundException;
import com.augeregalloydelisle.back.security.JwtUtility;
import com.augeregalloydelisle.back.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtility jwtUtility;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> request) {
        if (!request.containsKey("userName") || !request.containsKey("password")) {
            throw new BadRequestException("userName and password must be provided");
        }
        String userName = (String) request.get("userName");
        String password = (String) request.get("password");
        User user = userService.register(userName, password);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> login(@RequestBody Map<String, Object> request)
            throws RessourceNotFoundException, ForbiddenException {
        if (!request.containsKey("userName") || !request.containsKey("password")) {
            throw new BadRequestException("userName and password must be provided");
        }
        String userName = (String) request.get("userName");
        String password = (String) request.get("password");
        userService.login(userName, password);
        String token = jwtUtility.generatetoken(userName);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/hello")
    public ResponseEntity<?> hello(HttpServletRequest request) {

        String userName = (String) request.getAttribute("userName");
        User user = userService.findByUserName(userName);
        return ResponseEntity.ok(user);
    }
}
