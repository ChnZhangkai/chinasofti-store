package com.chinasofti.mall.web.entrance.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.mall.web.entrance.hystrix.PtMenuFeignClientHystrix;

@FeignClient(name = "userService" , fallback = PtMenuFeignClientHystrix.class)
public interface MenuFeignClient {
	
	@RequestMapping(value = "/menu/getMenu" )
	public String getMenu(@RequestParam(value = "pIds")String pIds);

	
	
}
