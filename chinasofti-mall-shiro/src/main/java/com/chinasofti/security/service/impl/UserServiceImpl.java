package com.chinasofti.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.security.entity.User;
import com.chinasofti.security.mapper.UserMapper;
import com.chinasofti.security.service.UserService;


@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserMapper userMapper;
    
    public User findUserByName(String username) {
        List<User> users = userMapper.findByUserName(username);
        return users.size() > 0 ? users.get(0) : null;
    }
    
}
