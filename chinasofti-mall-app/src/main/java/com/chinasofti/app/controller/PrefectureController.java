package com.chinasofti.app.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.PrefectureFeignClient;
import com.chinasofti.mall.common.entity.GoodsPrefecture;
import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.common.utils.DealParamFunctions;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 查询专区以及专区商品列表展示
 * @author chen
 *
 */
@RestController
@RequestMapping("prefecture")
public class PrefectureController {

	@Autowired
	private PrefectureFeignClient prefectureFeignClient;
	
	/**
	 * 查询专区列表
	 */
	@RequestMapping("queryPrefectureList")
	public ResponseInfo queryPrefectureList(){
		ResponseInfo response = new ResponseInfo();
		List<GoodsPrefecture> list = prefectureFeignClient.findAll();
		response = DealParamFunctions.dealResponseData(list);
		return response;
	}
	/**
	 * 查询专区下面商品列表
	 */
	@RequestMapping("queryPrefectureGoodsList")
	public ResponseInfo queryPrefectureGoodsList(@RequestBody(required = false) String ids){
		ResponseInfo response = new ResponseInfo();
		if(StringUtils.isEmpty(ids)){
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("专区Ids不能为空！");
			return response;
		}
		List<ChnGoodsOnline> result = prefectureFeignClient.findGoodsById(ids);
		response = DealParamFunctions.dealResponseData(result);
		return response;
	}
}
