package com.chinasofti.mall.goods.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.goods.service.IChnGoodsInfoService;
import com.github.pagehelper.util.StringUtil;

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
	@SuppressWarnings("null")
	@RequestMapping("queryGoodsList")
	public ResponseInfo queryGoodsList(@RequestParam("id") String id){
		String goodsClassIds = id;
		ResponseInfo response=null;
		if(StringUtil.isEmpty(goodsClassIds)){
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("分类Id不能为空！");
			return response;
		}
		
		response = goodsInfoService.selectByClassId(goodsClassIds);
		return response;
	} 
	 
	@SuppressWarnings("null")
	@RequestMapping("queryGoodsInfo")
	public ResponseInfo queryGoodsInfo(@RequestParam("ids") String ids) {
		ResponseInfo response = null;
		if (StringUtil.isEmpty(ids)) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("商品Ids不能为空！");
			return response;
		}
		response = goodsInfoService.selectByGoodsId(ids);
		return response;
	}
	/**
	 * 查询商品列表
	 * @param GoodsName
	 * @return queryGoodsInfoList 
	 */
	@SuppressWarnings("null")
	@RequestMapping("queryGoodsInfoList")
	public ResponseInfo queryGoodsInfoList(@RequestBody ChnGoodsinfo goodsInfo) {
		ResponseInfo response = null;
		if ((StringUtil.isNotEmpty(goodsInfo.getTitle())&& StringUtil.isEmpty(goodsInfo.getGoodsClassIds()))||(StringUtil.isEmpty(goodsInfo.getTitle()) && StringUtil.isNotEmpty(goodsInfo.getGoodsClassIds()))) {
			response = goodsInfoService.selectByNameOrother(goodsInfo);
		} else {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("关键字title或goodsClassIds不能为空！");
			return response;
		}

		return response;
	}
}