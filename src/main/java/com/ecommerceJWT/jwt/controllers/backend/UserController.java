package com.ecommerceJWT.jwt.controllers.backend;

import com.ecommerceJWT.jwt.entity.User;
import com.ecommerceJWT.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : jwt
 * @CreatedDate : 03/10/2024, Thursday
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.verifyUser(user);
    }

    @GetMapping("/view-all-users")
    public List<User> apiInfo(){
        return userService.getAllUsers();
    }
}
