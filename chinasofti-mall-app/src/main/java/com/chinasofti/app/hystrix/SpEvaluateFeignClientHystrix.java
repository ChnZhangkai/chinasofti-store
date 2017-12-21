package com.chinasofti.app.hystrix;

import org.springframework.stereotype.Component;

import com.chinasofti.app.feign.SpEvaluateFeignClient;
import com.chinasofti.mall.common.entity.spuser.SpGoodsEvaluate;

import net.sf.json.JSONObject;
@Component
public class SpEvaluateFeignClientHystrix implements SpEvaluateFeignClient{
	
	@Override
	public JSONObject selectEvaluateList(SpGoodsEvaluate spGoodsEvaluate) {
		JSONObject js = new JSONObject();
		return js;
	}
	
	@Override
	public JSONObject selectEvaluateAllList(SpGoodsEvaluate spGoodsEvaluate) {
		JSONObject js = new JSONObject();
		return js;
	}
	
 
	@Override
	public int insertSelective(SpGoodsEvaluate spGoodsEvaluate) {
		return 0;
	}

}
