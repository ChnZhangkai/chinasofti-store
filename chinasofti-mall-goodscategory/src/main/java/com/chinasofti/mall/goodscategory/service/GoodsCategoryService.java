package com.chinasofti.mall.goodscategory.service;

import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.common.service.IBaseService;

public interface GoodsCategoryService extends IBaseService<Goodscategory>{
	
	String selectByExample(Goodscategory goodscategory);
	
	int deleteById(Integer ids);
	
	Goodscategory selectById(Integer ids);
}
