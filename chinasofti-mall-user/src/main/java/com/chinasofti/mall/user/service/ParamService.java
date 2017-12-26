package com.chinasofti.mall.user.service;

import java.util.List;

import com.chinasofti.mall.common.entity.param.Param;

public interface ParamService {
	
	List<Param> findAll(Param param);
	
	List<Param> selectByPid(Integer pid);
	
}
