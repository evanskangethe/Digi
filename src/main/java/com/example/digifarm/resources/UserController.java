package com.example.digifarm.resources;

import com.example.digifarm.repository.entity.User;
import com.example.digifarm.services.impl.UserServiceImpl;
import com.example.digifarm.wrapper.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @RequestMapping(value = "/sign-up",method = RequestMethod.POST)
    public ResponseEntity<ResponseWrapper<User>> signUp(@RequestBody User user) {
        ResponseWrapper<User> wrapper  = userService.signUp(user);
        return ResponseEntity.ok(wrapper);
    }

}
