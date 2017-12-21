package com.chinasofti.app.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.app.hystrix.SpEvaluateFeignClientHystrix;
import com.chinasofti.mall.common.entity.spuser.SpGoodsEvaluate;

import net.sf.json.JSONObject;
@FeignClient(name = "userService" , fallback = SpEvaluateFeignClientHystrix.class)
public interface SpEvaluateFeignClient {
	
	@RequestMapping(value = "/evaluate/evaList")
	public JSONObject selectEvaluateList(@RequestBody SpGoodsEvaluate spGoodsEvaluate);
	
	@RequestMapping(value = "/evaluate/evaAllList")
	public JSONObject selectEvaluateAllList(@RequestBody SpGoodsEvaluate spGoodsEvaluate);
	
	@RequestMapping(value = "/evaluate/evaAdd")
	public int insertSelective(@RequestBody SpGoodsEvaluate spGoodsEvaluate);

}
