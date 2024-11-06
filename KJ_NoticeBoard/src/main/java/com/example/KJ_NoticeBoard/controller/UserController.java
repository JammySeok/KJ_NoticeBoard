package com.example.KJ_NoticeBoard.controller;

import com.example.KJ_NoticeBoard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String check() {
        return "Welcome to Spring boot";
    }

    @GetMapping(path = "/getusernames")
    public List<String> getAllUserNames() {
        return userRepository.getAllUserNames();
    }
}
