package com.chinasofti.app.hystrix;

import org.springframework.stereotype.Component;

import com.chinasofti.app.feign.SpEvaluateFeignClient;
import com.chinasofti.mall.common.entity.spuser.SpGoodsEvaluate;

import net.sf.json.JSONObject;
@Component
public class SpEvaluateFeignClientHystrix implements SpEvaluateFeignClient{
	
	@Override
	public JSONObject selectEvaluateList(SpGoodsEvaluate spGoodsEvaluate) {
		return null;
	}
	
	@Override
	public JSONObject selectEvaluateAllList(SpGoodsEvaluate spGoodsEvaluate) {
		return null;
	}
	
 
	@Override
	public int insertSelective(SpGoodsEvaluate spGoodsEvaluate) {
		return 0;
	}

}
