package com.chinasofti.mall.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.param.Param;
import com.chinasofti.mall.user.mapper.ParamMapper;
import com.chinasofti.mall.user.service.ParamService;
import com.github.pagehelper.PageHelper;

@Service
public class ParamServiceImpl implements ParamService{
	
	@Autowired
	private ParamMapper paramMapper;

	@Override
	public List<Param> findAll(Param param) {
		
		PageHelper.startPage(param.getPage(), param.getRows());
		List<Param> list = paramMapper.findAll(param);
		
		return list;
	}

}
