package com.nahrok.tourbackend.service.impl;

import com.nahrok.tourbackend.model.LoginRequest;
import com.nahrok.tourbackend.model.LoginResponse;
import com.nahrok.tourbackend.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public LoginResponse login(LoginRequest request) throws InterruptedException {
        if (true)
            Thread.sleep(10000);
        return new LoginResponse("token::success");
    }
}
