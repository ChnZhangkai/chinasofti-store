package com.chinasofti.mall.goods.service;


import java.util.List;

import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;

import net.sf.json.JSONObject;

public interface IChnGoodsClassService{
	
	public JSONObject selectByExample(ChnGoodsClass chnGoodsClass);
	
	public List<ChnGoodsClass> findGoodsClass(String ids);
	
	public ChnGoodsClass findById(String ids);
	
	public int updateById(ChnGoodsClass chnGoodsClass);
	
	public int saveGoodsClass(ChnGoodsClass chnGoodsClass);
	
	public int deleteById(String ids);
	
	public List<ChnGoodsClass> queryClass(String classId);
}
