package com.chinasofti.mall.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.goods.service.IChnGoodsInfoService;

@RestController
@RequestMapping("goodsInfo")
public class ChnGoodsInfoController {

	@Autowired
	private IChnGoodsInfoService goodsInfoService;
	
	@RequestMapping("queryGoodLis")
	public ResponseInfo queryGoodList(@RequestParam("id") String id){
		String goodsClassIds = id;
		return goodsInfoService.selectByClassId(goodsClassIds);
	}
	
	@RequestMapping("queryGoodsInfo")
	public ResponseInfo queryGoodsInfo(@RequestParam("ids") String ids){
		return goodsInfoService.selectByGoodsId(ids);
	}
}