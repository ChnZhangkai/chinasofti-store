package com.chinasofti.mall.goodscategory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.common.entity.GoodscategoryExample;
import com.chinasofti.mall.common.service.IBaseService;
import com.chinasofti.mall.goodscategory.mapper.GoodscategoryMapper;

@Service
public class GoodsCategoryService implements IBaseService<Goodscategory>{
	
	@Autowired
	private GoodscategoryMapper goodsCategoryMapper;
	
	@Override
	public int save(Goodscategory t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Goodscategory> findAll() {
		return goodsCategoryMapper.selectByExample(new GoodscategoryExample());
	}
	
	public List<Goodscategory> selectByExample(GoodscategoryExample example){
		return goodsCategoryMapper.selectByExample(example);
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

}
