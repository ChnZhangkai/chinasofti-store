package com.chinasofti.mall.goodscategory.service;

import java.util.List;

import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.common.entity.GoodscategoryExample;
import com.chinasofti.mall.common.service.IBaseService;

public interface GoodsCategoryService extends IBaseService<Goodscategory>{
	
	List<Goodscategory> selectByExample(GoodscategoryExample example);
	
}
