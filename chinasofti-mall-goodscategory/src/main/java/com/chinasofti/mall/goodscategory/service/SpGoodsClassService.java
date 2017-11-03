package com.chinasofti.mall.goodscategory.service;

import com.chinasofti.mall.common.entity.SpGoodsClass;
import com.chinasofti.mall.common.service.IBaseService;

public interface SpGoodsClassService extends IBaseService<SpGoodsClass>{
	
	String selectByExample(SpGoodsClass spGoodsClass);
	
	SpGoodsClass selectById(String ids);
	
	int updateByExample(SpGoodsClass spGoodsClass);
	
	int deleteById(String ids);
	
}
