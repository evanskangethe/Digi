package com.example.digifarm.services.impl;

import com.example.digifarm.repository.UserRepository;
import com.example.digifarm.repository.entity.User;
import com.example.digifarm.services.UserService;
import com.example.digifarm.wrapper.ResponseWrapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public  UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    public UserServiceImpl() {
    }

    @Override
    public ResponseWrapper<User> signUp(User user) {
        ResponseWrapper<User> responseWrapper = new ResponseWrapper<>();

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        responseWrapper.setCode(HttpStatus.OK.value());
        responseWrapper.setMessage("User Created Successfully");
        responseWrapper.setData(userRepository.save(user));
        return responseWrapper;
    }
}
