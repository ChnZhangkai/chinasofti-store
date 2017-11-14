package com.chinasofti.mall.web.entrance.service;

import com.chinasofti.mall.common.entity.goods.GoodsFile;

public interface GoodsFileService {
	
	int insert(GoodsFile record);
	
	GoodsFile selectByPrimaryKey(String ids);
	
	int updateByPrimaryKeySelective(GoodsFile record);
	
	int deleteByPrimaryKey(String ids);
	
	int deleteByGoodsIds(String ids);
	
	GoodsFile selectByGoodsIds(String ids);
	
}
