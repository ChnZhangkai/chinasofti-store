package com.chinasofti.mall.web.entrance.mapper;

import java.util.List;

import com.chinasofti.mall.common.entity.PtUser;


public interface UserMapper {
    
    List<PtUser> findByUserName(String username);
}
