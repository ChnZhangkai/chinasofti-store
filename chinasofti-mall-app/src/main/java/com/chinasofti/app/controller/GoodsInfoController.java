package com.chinasofti.app.controller;

 

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.GoodsInfoFeignClient;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.utils.ResponseInfo;
/**
 * 主要查询商品列表、商品详情、和关键字查询
 * @author gezhenlin
 *
 */
@RestController
@RequestMapping("goodsInfo")
public class GoodsInfoController {
	
	@Autowired
	private GoodsInfoFeignClient goodsFeignClient;
	
	/**
	 * 根据Ids查询商品列表
	 * @param classId(ids)
	 * @return
	 */
	@RequestMapping("queryGoodsList")
	public ResponseInfo queryGoodList(@RequestParam("id") String id,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return goodsFeignClient.queryGoodList(id);
	}
	@RequestMapping("queryGoodsInfo")
	public ResponseInfo queryGoodsInfo(@RequestParam("ids") String ids,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return goodsFeignClient.queryGoodInfo(ids);
	}
	/**
	 * 
	 * @param goodsInfo
	 * @param response
	 * @return
	 */
	@RequestMapping("queryGoodsInfoList")
	public ResponseInfo queryGoodsInfoList(@RequestBody ChnGoodsinfo goodsInfo, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		return goodsFeignClient.queryGoodsInfoList(goodsInfo);
	}
}
