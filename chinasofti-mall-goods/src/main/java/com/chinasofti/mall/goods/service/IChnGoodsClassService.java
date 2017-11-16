package com.chinasofti.mall.goods.service;


import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.utils.ResponseInfo;

import net.sf.json.JSONObject;

public interface IChnGoodsClassService{
	
	public JSONObject selectByExample(ChnGoodsClass chnGoodsClass);
	
	public ChnGoodsClass findById(String ids);
	
	public int updateById(ChnGoodsClass chnGoodsClass);
	
	public int saveGoodsClass(ChnGoodsClass chnGoodsClass);
	
	public int deleteById(String ids);
	
	public ResponseInfo queryClass(String classId);
}
