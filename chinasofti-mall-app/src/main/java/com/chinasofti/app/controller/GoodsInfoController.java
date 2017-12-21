package com.chinasofti.app.controller;

 

import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.GoodsInfoFeignClient;
import com.chinasofti.mall.common.entity.goods.ChnGoodsInfoVo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.SkuGoodsVo;
import com.chinasofti.mall.common.utils.DealParamFunctions;
import com.chinasofti.mall.common.utils.MsgEnum;
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
	public ResponseInfo queryGoodList(@RequestParam("id") String id){
		ResponseInfo response = new ResponseInfo();
		if(StringUtils.isEmpty(id)){
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("分类Id不能为空！");
			return response;
		}
		List<ChnGoodsinfo> result =goodsFeignClient.queryGoodList(id);
		response = DealParamFunctions.dealResponseData(result);
		return response;
	}
	@RequestMapping("queryGoodsInfo")
	public ResponseInfo queryGoodsInfo(@RequestParam("ids") String ids){
		ResponseInfo response = new ResponseInfo();
		if (StringUtils.isEmpty(ids)) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("商品Ids不能为空！");
			return response;
		}
		ChnGoodsInfoVo result = goodsFeignClient.queryGoodInfo(ids);
		response = DealParamFunctions.dealResponseData(result);
		return response;
	}
	/**
	 * 
	 * @param goodsInfo
	 * @param response
	 * @return
	 */
	@RequestMapping("queryGoodsInfoList")
	public ResponseInfo queryGoodsInfoList(@RequestBody ChnGoodsinfo goodsInfo){
		ResponseInfo response = new ResponseInfo();
		if ((StringUtils.isEmpty(goodsInfo.getTitle())&& StringUtils.isEmpty(goodsInfo.getGoodsClassIds()))||(StringUtils.isNotEmpty(goodsInfo.getTitle()) && StringUtils.isNotEmpty(goodsInfo.getGoodsClassIds()))) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("关键字title或goodsClassIds不能同时为空！");
			return response;
		} 
		List<ChnGoodsinfo>result = goodsFeignClient.queryGoodsInfoList(goodsInfo);
		response = DealParamFunctions.dealResponseData(result);
		return response;
	}
	/**
	* @Title: findSkuByGoodsIds
	* @Description: 查询sku商品
	* @param  ids
	* @param   参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping("findSkuByGoodsIds")
	public ResponseInfo  findSkuByGoodsIds(@RequestParam("ids") String ids) {
		ResponseInfo response = new ResponseInfo();
		if (StringUtils.isEmpty(ids)) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("商品Ids不能为空！");
			return response;
		}
		List<SkuGoodsVo> skuList = goodsFeignClient.findSkuByGoodsIds(ids);
		response = DealParamFunctions.dealResponseData(skuList);
		return response;
		
	
		
	}
	
}
