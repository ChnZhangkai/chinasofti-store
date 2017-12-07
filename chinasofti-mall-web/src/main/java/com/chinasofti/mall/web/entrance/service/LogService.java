package com.chinasofti.mall.web.entrance.service;

import java.util.List;

import com.chinasofti.mall.common.entity.LogOperator;

public interface LogService {
	
	public List<LogOperator> selectByLogOperator(LogOperator logOperator); 
	
	public int insert(LogOperator record);
	
	public int updateByPrimaryKeySelective(LogOperator logOperator);
	
}
