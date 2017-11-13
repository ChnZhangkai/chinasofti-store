package com.chinasofti.mall.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.goods.service.ChnGoodsOnlineService;

import net.sf.json.JSONObject;

/**
 * 商品在线管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goodsOnline")
public class ChnGoodsOnlineController {

	@Autowired
	private ChnGoodsOnlineService chnGoodsOnlineServiceImpl;
	/**
	 * 列表及条件查询
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/list" , method = RequestMethod.POST)
	public JSONObject selectByGoodsOnline(@RequestBody(required = false)ChnGoodsOnline chnGoodsOnline){
		return chnGoodsOnlineServiceImpl.selectByExample(chnGoodsOnline);
		
	}
	
}
