package com.chinasofti.mall.goods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.goods.mapper.ChnGoodsinfoMapper;
import com.chinasofti.mall.goods.service.IChnGoodsInfoService;

@Service
public class ChnGoodsInfoService implements IChnGoodsInfoService{

	@Autowired
	private ChnGoodsinfoMapper goodsinfoMapper;
	
	public List<ChnGoodsinfo> selectByClassId(String goodsClassIds) {
		return goodsinfoMapper.selectByClassId(goodsClassIds);
	}

	public ChnGoodsinfo selectByGoodsId(String ids) {
		return goodsinfoMapper.selectByPrimaryKey(ids);
	}
}
