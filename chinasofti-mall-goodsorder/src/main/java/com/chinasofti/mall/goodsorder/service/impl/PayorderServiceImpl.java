package com.chinasofti.mall.goodsorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.order.PyPayorder;
import com.chinasofti.mall.common.entity.order.PyPayorderExample;
import com.chinasofti.mall.goodsorder.mapper.PyPayorderMapper;
import com.chinasofti.mall.goodsorder.service.PayorderService;


/**
* @ClassName: 	PayorderServiceImpl
* @Description: 支付订单service实现类
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月3日 上午11:50:40 
*/
@Service
public class PayorderServiceImpl implements PayorderService {
	
	@Autowired
	private PyPayorderMapper payorderMapper;

	@Override
	public int save(PyPayorder Paysorder) {
		
		return payorderMapper.insertSelective(Paysorder);
	}

	@Override
	public List<PyPayorder> findAll() {
		return null;
	}

	@Override
	public PyPayorder findById(String id) {
		
		return payorderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(String id) {
		
		return payorderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(PyPayorder Paysorder) {
		
		return payorderMapper.updateByPrimaryKeySelective(Paysorder);
	}
	
	@Override
	public List<PyPayorder> selectByExample(PyPayorderExample example){
		
		return payorderMapper.selectByExample(example);
	}

}
