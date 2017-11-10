package com.chinasofti.mall.web.entrance.service;

import com.chinasofti.mall.common.entity.PtUser;

public interface UserService {
    public PtUser findUserByName(String username);
}
