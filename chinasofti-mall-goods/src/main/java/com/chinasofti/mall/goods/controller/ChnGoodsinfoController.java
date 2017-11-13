package com.chinasofti.mall.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.goods.service.IChnGoodsInfoService;

@RestController
@RequestMapping("goodsInfo")
public class ChnGoodsinfoController {

	@Autowired
	private IChnGoodsInfoService goodsInfoService;
	
	@RequestMapping("queryGoodList/{id}")
	public List<ChnGoodsinfo>queryGoodList(@PathVariable String id){
		String goodsClassIds = id;
		return goodsInfoService.selectByClassId(goodsClassIds);
	}
	
	@RequestMapping("queryGoodsInfo/{ids}")
	public ChnGoodsinfo queryGoodsInfo(@PathVariable String ids){
		return goodsInfoService.selectByGoodsId(ids);
	}
}