package com.chinasofti.mall.goodscategory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.common.entity.GoodscategoryExample;
import com.chinasofti.mall.goodscategory.mapper.GoodscategoryMapper;
import com.chinasofti.mall.goodscategory.service.GoodsCategoryService;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService{
	
	@Autowired
	private GoodscategoryMapper goodscategoryMapper;

	@Override
	public int save(Goodscategory t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Goodscategory> findAll() {
		
		return null;
	}

	@Override
	public Goodscategory findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Goodscategory t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Goodscategory> selectByExample(GoodscategoryExample example) {
		// TODO Auto-generated method stub
		return goodscategoryMapper.selectByExample(example);
	}
	


}
