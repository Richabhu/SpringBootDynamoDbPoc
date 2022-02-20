package com.springboot.dynamodb.controller;


import com.springboot.dynamodb.dto.UserDTO;
import com.springboot.dynamodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/validate")
    public UserDTO insertIntoDynamoDB(@RequestBody UserDTO dto) {
        return  userService.insertIntoDynamoDB(dto);
    }
}