package com.chinasofti.mall.web.entrance.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.mall.common.entity.param.Param;
import com.chinasofti.mall.web.entrance.hystrix.PtUserFeignClientHystrix;

import net.sf.json.JSONObject;

@FeignClient(name = "userService" , fallback = PtUserFeignClientHystrix.class)
public interface ParamFeigClient {
	
	@RequestMapping(value = "/param/list" , method = RequestMethod.POST)
	public JSONObject findAll(@RequestBody(required = false) Param param);
	
}
