package com.ecommerceJWT.jwt.repository;

import com.ecommerceJWT.jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : jwt
 * @CreatedDate : 03/10/2024, Thursday
 **/
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserName(String username);
}
