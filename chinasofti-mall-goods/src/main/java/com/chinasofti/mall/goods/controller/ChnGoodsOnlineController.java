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
	 * @param chnGoodsOnline
	 * @return
	 */
	@RequestMapping(value = "/list" , method = RequestMethod.POST)
	public JSONObject selectByGoodsOnline(@RequestBody(required = false)ChnGoodsOnline chnGoodsOnline){
		return chnGoodsOnlineServiceImpl.selectByExample(chnGoodsOnline);
 
	}
	
	/**
	 * 商品上架
	 * @param chnGoodsOnline
	 * @return
	 */
	@RequestMapping(value = "/updateGoodsStatus" , method = RequestMethod.POST)
	public int updateGoodsStatus(@RequestBody(required = false)ChnGoodsOnline chnGoodsOnline){
		return chnGoodsOnlineServiceImpl.updateGoodsStatus(chnGoodsOnline);
 
	}
	
	/**
	 * 修改商品库存
	 * @param chnGoodsOnline
	 * @return
	 */
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public int updateGoodsStore(@RequestBody(required = false)ChnGoodsOnline chnGoodsOnline){
		return chnGoodsOnlineServiceImpl.update(chnGoodsOnline);
 
	}

}
