package com.nahrok.tourbackend.service;

import com.nahrok.tourbackend.model.LoginRequest;
import com.nahrok.tourbackend.model.LoginResponse;

public interface IUserService {
    LoginResponse login(LoginRequest request) throws InterruptedException;
}
