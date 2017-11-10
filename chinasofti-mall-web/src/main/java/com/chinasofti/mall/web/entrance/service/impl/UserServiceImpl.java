package com.chinasofti.mall.web.entrance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.web.entrance.mapper.UserMapper;
import com.chinasofti.mall.web.entrance.service.UserService;


@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserMapper userMapper;
    
    public PtUser findUserByName(String username) {
        List<PtUser> users = userMapper.findByUserName(username);
        return users.size() > 0 ? users.get(0) : null;
    }
    
}
