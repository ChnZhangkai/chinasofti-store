package com.chinasofti.mall.user.service;

import com.chinasofti.mall.common.entity.spuser.SpGoodsEvaluate;

import net.sf.json.JSONObject; 

public interface SpEvaluateService {
	/*
	 * 查询已评论列表   未评论列表
	 * */
	public JSONObject selectEvaluateList(SpGoodsEvaluate spGoodsEvaluate)throws Exception;
	
	
	/*
	 * 商品评论列表
	 * */
	public JSONObject selectEvaluateAllList(SpGoodsEvaluate spGoodsEvaluate)throws Exception;
	
	/*
	 * 插人评论信息
	 * */
	public int insertSelective(SpGoodsEvaluate SpGoodsEvaluate)throws Exception;
	
}
