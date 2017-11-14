package com.chinasofti.mall.goods.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.goods.service.IChnGoodsInfoService;

/**
 * 查询商品列表或商品详情信息
 * @author gezhenlin
 *
 */
@RestController
@RequestMapping("goodsInfo")
public class ChnGoodsInfoController {

	@Autowired
	private IChnGoodsInfoService goodsInfoService;
	/**
	 * 查询商品列表
	 * @param id
	 * @return queryGoodList 
	 */
	@RequestMapping("queryGoodList")
	public ResponseInfo queryGoodList(@RequestParam("id") String id){
		String goodsClassIds = id;
		return goodsInfoService.selectByClassId(goodsClassIds);
	} 
	 
	@RequestMapping("queryGoodsInfo")
	public ResponseInfo queryGoodsInfo(@RequestParam("ids") String ids){
		return goodsInfoService.selectByGoodsId(ids);
	}
}