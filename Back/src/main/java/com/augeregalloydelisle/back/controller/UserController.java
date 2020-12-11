package com.augeregalloydelisle.back.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")

public class UserController {
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String,Object>request)
    {
        String username = (String) request.get("username");
        String password = (String) request.get("password");
        return ResponseEntity.ok(username+" "+password);
    }
}
