package com.chinasofti.mall.goodsorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.PyChildGoodsorderExample;
import com.chinasofti.mall.goodsorder.mapper.PyChildGoodsorderMapper;
import com.chinasofti.mall.goodsorder.service.ChildGoodsorderService;


/**
* @ClassName: 	ChildGoodsorderServiceImpl
* @Description: 子订单service实现类
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月3日 上午11:49:43 
*/
@Service
public class ChildGoodsorderServiceImpl implements ChildGoodsorderService {
	
	@Autowired
	private PyChildGoodsorderMapper childGoodsorderMapper;

	@Override
	public int save(PyChildGoodsorder childGoodsorder) {
		
		return childGoodsorderMapper.insertSelective(childGoodsorder);
	}

	@Override
	public List<PyChildGoodsorder> findAll() {
		return null;
	}

	@Override
	public PyChildGoodsorder findById(String id) {
		
		return childGoodsorderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(String id) {
		
		return childGoodsorderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(PyChildGoodsorder childGoodsorder) {
		
		return childGoodsorderMapper.updateByPrimaryKeySelective(childGoodsorder);
	}
	
	@Override
	public List<PyChildGoodsorder> selectByExample(PyChildGoodsorderExample example){
		
		return childGoodsorderMapper.selectByExample(example);
	}

}
