package com.chinasofti.mall.goods.service;

import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;

import net.sf.json.JSONObject;

public interface ChnGoodsOnlineService {

	/**
	 * @param chnGoodsOnline
	 * @return
	 */ 
	JSONObject selectByExample(ChnGoodsOnline chnGoodsOnline);
}
