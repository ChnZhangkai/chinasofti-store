package com.chinasofti.app.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.SpEvaluateFeignClient;
import com.chinasofti.mall.common.entity.spuser.SpGoodsEvaluate;
import com.chinasofti.mall.common.utils.DealParamFunctions;
import com.chinasofti.mall.common.utils.ResponseInfo;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/evaluate")
@Component
public class SpEvaluateController {
	@Autowired
	SpEvaluateFeignClient spEvaluateFeignClient;
	
	
	@RequestMapping(value = "/evaList" , method = RequestMethod.POST)
	public ResponseInfo selectEvaluateList(@RequestBody SpGoodsEvaluate spGoodsEvaluate,HttpServletResponse response){
		JSONObject obj = spEvaluateFeignClient.selectEvaluateList(spGoodsEvaluate);
		return DealParamFunctions.dealResponseData(obj);
	}
	
	@RequestMapping(value = "/evllaAList" , method = RequestMethod.POST)
	public ResponseInfo selectEvaluateAllList(@RequestBody SpGoodsEvaluate spGoodsEvaluate,HttpServletResponse response){
		JSONObject obj = spEvaluateFeignClient.selectEvaluateAllList(spGoodsEvaluate);
		return DealParamFunctions.dealResponseData(obj);
	}
	
	@RequestMapping(value = "/evaAdd" , method = RequestMethod.POST)
	public ResponseInfo insertSelective(@RequestBody SpGoodsEvaluate spGoodsEvaluate,HttpServletResponse response){
		ResponseInfo res = new ResponseInfo() ;
		int result=spEvaluateFeignClient.insertSelective(spGoodsEvaluate); 
		if(result == 0 ){
			res.setRetCode("999999");
			res.setRetMsg("评论功能异常");
			return res;
		}
		return DealParamFunctions.dealResponseData(result);
	}

}
