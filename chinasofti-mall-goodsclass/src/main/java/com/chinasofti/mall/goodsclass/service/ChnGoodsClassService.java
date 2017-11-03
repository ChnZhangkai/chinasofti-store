package com.chinasofti.mall.goodsclass.service;

import com.chinasofti.mall.common.entity.ChnGoodsClass;
import com.chinasofti.mall.common.service.IBaseService;

import net.sf.json.JSONObject;

public interface ChnGoodsClassService extends IBaseService<ChnGoodsClass>{
	
	JSONObject selectByExample(ChnGoodsClass chnGoodsClass);
	
	int deleteById(String ids);
	
}
