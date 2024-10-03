package com.ecommerceJWT.jwt.service;

import com.ecommerceJWT.jwt.entity.User;
import com.ecommerceJWT.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : jwt
 * @CreatedDate : 03/10/2024, Thursday
 **/
@Service
public class UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager manager;

    public User register(User user){
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       return userRepository.save(user);
    }

    public String verifyUser(User user) {
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword())
        );
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUserName());
        }
        return "Failed";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
