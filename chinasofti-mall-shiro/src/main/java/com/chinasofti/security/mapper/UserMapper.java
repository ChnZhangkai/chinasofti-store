package com.chinasofti.security.mapper;

import java.util.List;

import com.chinasofti.security.entity.User;


public interface UserMapper {
    
    List<User> findByUserName(String username);
}
