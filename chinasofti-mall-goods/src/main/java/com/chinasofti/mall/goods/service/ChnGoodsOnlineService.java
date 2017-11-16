package com.chinasofti.mall.goods.service;

import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;

import net.sf.json.JSONObject;

public interface ChnGoodsOnlineService {

	/**
	 * @param chnGoodsOnline
	 * @return
	 */ 
	JSONObject selectByExample(ChnGoodsOnline chnGoodsOnline);

	/**
	 * @param chnGoodsOnline
	 * @return
	 */
	int updateGoodsStatus(ChnGoodsOnline chnGoodsOnline);

	/**
	 * @param chnGoodsOnline
	 * @return
	 */
	int update(ChnGoodsinfoCheck chnGoodsinfoCheck);
}
