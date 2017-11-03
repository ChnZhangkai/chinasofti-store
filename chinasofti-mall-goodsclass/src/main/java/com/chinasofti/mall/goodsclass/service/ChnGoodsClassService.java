package com.chinasofti.mall.goodsclass.service;

import com.chinasofti.mall.common.entity.ChnGoodsClass;
import com.chinasofti.mall.common.service.IBaseService;

public interface ChnGoodsClassService extends IBaseService<ChnGoodsClass>{
	
	String selectByExample(ChnGoodsClass chnGoodsClass);
	
	int deleteById(String ids);
	
}
