package com.chinasofti.mall.goodsorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.PyMainGoodsorder;
import com.chinasofti.mall.common.entity.PyMainGoodsorderExample;
import com.chinasofti.mall.common.service.IBaseService;
import com.chinasofti.mall.goodsorder.mapper.PyMainGoodsorderMapper;

@Service
public class GoodsorderService implements IBaseService<PyMainGoodsorder>{
	
	@Autowired
	PyMainGoodsorderMapper pyMainGoodsorderMapper;

	@Override
	public PyMainGoodsorder save(PyMainGoodsorder goodsorder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PyMainGoodsorder> findAll() {
		return pyMainGoodsorderMapper.selectByExample(new PyMainGoodsorderExample());
	}

	@Override
	public PyMainGoodsorder findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(PyMainGoodsorder goodsorder) {
		// TODO Auto-generated method stub
		return 0;
	}

}
