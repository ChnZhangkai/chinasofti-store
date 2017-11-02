package com.chinasofti.mall.goodsorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.PyMainGoodsorder;
import com.chinasofti.mall.common.entity.PyMainGoodsorderExample;
import com.chinasofti.mall.common.entity.PyMainGoodsorderWithBLOBs;
import com.chinasofti.mall.common.service.IBaseService;
import com.chinasofti.mall.goodsorder.mapper.PyMainGoodsorderMapper;

@Service
public class MainGoodsorderService implements IBaseService<PyMainGoodsorder>{
	
	@Autowired
	PyMainGoodsorderMapper pyMainGoodsorderMapper;

	@Override
	public int save(PyMainGoodsorder goodsorder) {
		return 0;
	}

	@Override
	public List<PyMainGoodsorder> findAll() {
		return pyMainGoodsorderMapper.selectByExample(new PyMainGoodsorderExample());
	}

	@Override
	public PyMainGoodsorder findById(String id) {
		return pyMainGoodsorderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(String id) {
		return pyMainGoodsorderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(PyMainGoodsorder goodsorder) {
		return 0;
	}

	public int updateByPrimaryKeySelective(PyMainGoodsorderWithBLOBs goodsorderWithBLOBs) {
		return pyMainGoodsorderMapper.updateByPrimaryKeySelective(goodsorderWithBLOBs);
	}
	
	public int saveWithBLOBs(PyMainGoodsorderWithBLOBs goodsorderWithBLOBs) {
		return pyMainGoodsorderMapper.insertSelective(goodsorderWithBLOBs);
	}

}
