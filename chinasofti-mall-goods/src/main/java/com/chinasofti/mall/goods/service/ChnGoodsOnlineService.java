package com.chinasofti.mall.goods.service;

import java.util.Map;

import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;

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
	int update(ChnGoodsOnline chnGoodsOnline);

	/**
	 * @param map
	 * @return
	 */
	Map<String, Object> findByPage(Map<String, Object> map);

}
