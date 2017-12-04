package com.chinasofti.mall.goods.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.goods.ChnGoodsInfoVo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.goods.mapper.ChnGoodsInfoMapper;
import com.chinasofti.mall.goods.service.IChnGoodsInfoService;

@Service
public class ChnGoodsInfoService implements IChnGoodsInfoService{

	@Autowired
	private ChnGoodsInfoMapper goodsinfoMapper;
	
	public List<ChnGoodsinfo> selectByClassId(String goodsClassIds) {
		return goodsinfoMapper.selectByClassId(goodsClassIds);
		
	}
	
	public ChnGoodsInfoVo selectByGoodsId(String ids) {
		return goodsinfoMapper.selectByPrimaryKey(ids);
		
	}
		/**
	     * 根据关键字查询商品列表
	     * @param record
	     * @return
	     */
		@Override
		public List<ChnGoodsinfo> selectByNameOrother(ChnGoodsinfo goodsInfo) {
			
			return goodsinfoMapper.selectByNameOrother(goodsInfo);
			
		}

}
