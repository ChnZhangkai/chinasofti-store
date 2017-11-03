package com.chinasofti.mall.goodsorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.PyMainGoodsorder;
import com.chinasofti.mall.common.entity.PyMainGoodsorderExample;
import com.chinasofti.mall.goodsorder.mapper.PyMainGoodsorderMapper;
import com.chinasofti.mall.goodsorder.service.MainGoodsorderService;

/**
* @ClassName: 	MainGoodsorderServiceImpl
* @Description: 主订单Service实现类
*
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月2日 上午11:20:19 
*
*/
@Service
public class MainGoodsorderServiceImpl implements MainGoodsorderService {
	
	@Autowired
	private PyMainGoodsorderMapper mainGoodsorderMapper;

	@Override
	public int save(PyMainGoodsorder mainGoodsorder) {
		
		return mainGoodsorderMapper.insertSelective(mainGoodsorder);
	}

	@Override
	public List<PyMainGoodsorder> findAll() {
		return null;
	}

	@Override
	public PyMainGoodsorder findById(String id) {
		
		return mainGoodsorderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(String id) {
		
		return mainGoodsorderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(PyMainGoodsorder mainGoodsorder) {
		
		return mainGoodsorderMapper.updateByPrimaryKeySelective(mainGoodsorder);
	}
	
	@Override
	public List<PyMainGoodsorder> selectByExample(PyMainGoodsorderExample example){
		
		return mainGoodsorderMapper.selectByExample(example);
	}

}
