package com.charles.webflux.controller;

import com.charles.business.mapper.UserMapper;
import com.charles.business.model.User;
import com.charles.webflux.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jaycekon on 2018/1/10.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping(value = "/save")
    public Object save(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user;
    }
}
