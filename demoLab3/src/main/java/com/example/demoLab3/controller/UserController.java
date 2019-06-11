package com.example.demoLab3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoLab3.model.User;

@RestController
@RequestMapping(value="/v1/users")
public class UserController {

    private UserService userService;

    public ResponseEntity<User> findByLogin(){
        User user = userService.finByLogin;
        return userService.findByLogin;
    }

}