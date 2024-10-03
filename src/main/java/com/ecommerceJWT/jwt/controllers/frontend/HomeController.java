package com.ecommerceJWT.jwt.controllers.frontend;

import com.ecommerceJWT.jwt.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : jwt
 * @CreatedDate : 03/10/2024, Thursday
 **/
@RestController
public class HomeController {
    @GetMapping("/")
    public String apiInfo(){
        return "E-com Api version 1";
    }


}
