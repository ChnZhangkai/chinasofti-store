package com.chinasofti.mall.web.entrance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.LogOperator;
import com.chinasofti.mall.web.entrance.mapper.LogOperatorMapper;
import com.chinasofti.mall.web.entrance.service.LogService;
import com.github.pagehelper.PageHelper;

@Service
public class LogOperatorImpl implements LogService{
	
	@Autowired
	private LogOperatorMapper logOperatorMapper;
	
	@Override
	public List<LogOperator> selectByLogOperator(LogOperator logOperator) {
		
		PageHelper.startPage(logOperator.getPage(),logOperator.getRows());
		List<LogOperator> list = logOperatorMapper.selectByLogOperator(logOperator);
		
		return list;
	}

	@Override
	public int insert(LogOperator logOperator) {
		int insertStatus = logOperatorMapper.insert(logOperator);
		return insertStatus;
	}

	@Override
	public int updateByPrimaryKeySelective(LogOperator logOperator) {
		int updateStatus = logOperatorMapper.updateByPrimaryKeySelective(logOperator);
		return updateStatus;
	}

}
