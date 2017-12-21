package com.chinasofti.mall.goods.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.goods.ChnGoodsInfoVo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.SkuGoodsVo;
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
	@RequestMapping("queryGoodsList")
	public List<ChnGoodsinfo> queryGoodsList(@RequestParam("id") String id){
		String goodsClassIds = id;
		return goodsInfoService.selectByClassId(goodsClassIds);
		 
	} 
	 
	@RequestMapping("queryGoodsInfo")
	public ChnGoodsInfoVo queryGoodsInfo(@RequestParam("ids") String ids) {
		
		return goodsInfoService.selectByGoodsId(ids);	 
	}
	/**
	 * 查询商品列表
	 * @param GoodsName
	 * @return queryGoodsInfoList 
	 */
	@RequestMapping("queryGoodsInfoList")
	public List<ChnGoodsinfo> queryGoodsInfoList(@RequestBody ChnGoodsinfo goodsInfo) {
	
		return goodsInfoService.selectByNameOrother(goodsInfo);
	}
	/**
	 * 根据商品Id查询商品信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("checkGoodsInfoById")
	public ChnGoodsinfo checkGoodsInfoById(@RequestParam("ids")String ids) {
		return goodsInfoService.checkGoodsInfoById(ids);
		
	}
	
	/**
	 * 
	* @Title: findSkuByGoodsIds
	* @Description: 根据商品id查询sku信息
	* @param  ids
	* @return List<SkuGoodsVo> 
	* @throws
	 */
	@RequestMapping(value="findSkuByGoodsIds",method=RequestMethod.GET)
	public List<SkuGoodsVo> findSkuByGoodsIds(@RequestParam("ids") String ids){
		return goodsInfoService.findSkuByGoodsIds(ids);		
	}
}