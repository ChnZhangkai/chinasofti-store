package com.chinasofti.security.service;

import com.chinasofti.security.entity.User;


public interface UserService {
    public User findUserByName(String username);
}
