package com.chinasofti.mall.web.entrance.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.mall.common.entity.PtHrUserBak;
import com.chinasofti.mall.web.entrance.hystrix.PtHrUserFeignClientHystrix;

@FeignClient(name = "userService" , fallback = PtHrUserFeignClientHystrix.class)
public interface PtHrUserFeignClient {
	
	@RequestMapping(value = "/user/select" , method = RequestMethod.POST)
	public String selectByUser(@RequestBody(required = false) PtHrUserBak ptHrUserBak);
	
}
