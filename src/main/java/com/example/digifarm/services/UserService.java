package com.example.digifarm.services;

import com.example.digifarm.repository.entity.User;
import com.example.digifarm.wrapper.ResponseWrapper;

public interface UserService {
    ResponseWrapper<User> signUp(User user);
}
