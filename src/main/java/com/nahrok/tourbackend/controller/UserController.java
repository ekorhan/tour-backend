package com.nahrok.tourbackend.controller;

import com.nahrok.tourbackend.model.LoginRequest;
import com.nahrok.tourbackend.model.LoginResponse;
import com.nahrok.tourbackend.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) throws InterruptedException {
        return userService.login(request);
    }
}
